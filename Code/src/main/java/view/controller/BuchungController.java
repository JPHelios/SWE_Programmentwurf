package view.controller;

import app.Carsharing;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleListComponent;
import model.buchung.Buchung;
import model.buchung.Rabattaktion;
import model.buchung.Rechnung;
import model.fahrzeug.Fahrzeug;
import model.fahrzeug.Fahrzeugklasse;
import model.kunde.Kunde;
import model.standort.Filiale;
import model.standort.Mitarbeiter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import org.apache.commons.lang3.ArrayUtils;
import util.BuchungBuilder;
import util.FahrzeugBuilder;
import view.gui.BuchungGUI;
import view.gui.FahrzeugGUI;
import view.utils.GUIController;

import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class BuchungController extends GUIController {

    Buchung currentBuchung;
    BuchungGUI gui;
    ArrayList<String> ausruestungTmp = new ArrayList<String>();

    public BuchungController(BuchungGUI gui){
        this.gui = gui;
    }
    public List<Buchung> loadData(){

        List<Object> test = Carsharing.em.getAllEl(Buchung.class);
        List<Buchung> buchungList = new ArrayList<>();

        for(Object el : test){
            buchungList.add((Buchung) el);
        }

        return buchungList;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

        if (guiEvent.getCmd() == SimpleListComponent.Commands.ELEMENT_SELECTED){
            if (guiEvent.getData() instanceof Buchung) {
                currentBuchung = (Buchung) guiEvent.getData();

                JPanel panel = gui.createRightSidePanel(0);
                gui.createRightSide(panel);
                updateDetailLabelTexts();
                gui.setRightSiteVisible(panel);
            }
        }

        if (guiEvent.getCmd() == ButtonElement.Commands.BUTTON_PRESSED) {
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Anlegen")){
                System.out.println("Es wurde Anlegen geklickt");
                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.buchungList);

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Filter")){
                System.out.println("Es wurde Filter geklickt");

                List<Buchung> buchungen = loadData();

                String searchField = gui.searchField.getText();



                if(buchungen.size() != 0 ){
                    gui.buchungList.removeAllListElements();
                    gui.buchungList.setListElements(buchungen);
                } else {
                    gui.buchungList.setListElements(loadData());
                    JOptionPane.showMessageDialog(gui, "Es konnte leider kein übereinstimmender Eintrag gefunden werden");
                }


            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Create")){
                System.out.println("Es wurde Create geklickt");

                JPanel panel = gui.createRightSidePanel(1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.buchungList);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save")){
                System.out.println("Es wurde Speichern geklickt");

                checkZeitspanne();

                //Eingabeüberprüfung muss noch eingebaut werden!!!


                Fahrzeug fahrzeug = (Fahrzeug) gui.fahrzeugSelect.getSelectedItem();
                Date startTermin = (Date) gui.startTerminPicker.getModel().getValue();
                Date endTermin = (Date) gui.endTerminPicker.getModel().getValue();
                Kunde kunde = (Kunde) gui.kundeSelect.getSelectedItem();
                Mitarbeiter mitarbeiter = (Mitarbeiter) gui.mitarbeiterSelect.getSelectedItem();
                Rabattaktion rabatt = (Rabattaktion) gui.rabatteDropDown.getSelectedItem();

                String fID = fahrzeug.getFahrzeugID();
                String kID = kunde.getKundeID();
                String mID = mitarbeiter.getMitarbeiterID();

                try{

                    BuchungBuilder bb = new BuchungBuilder();
                    bb.kunde(kID);
                    bb.starttermin(startTermin);
                    bb.endtermin(endTermin);
                    bb.fahrzeug(fID);
                    bb.mitarbeiter(mID);

                    Buchung b = bb.build();

                    b.setMahnungIDs(new String[]{});

                    Rechnung r  = Carsharing.ef.createRechnung(b, Objects.requireNonNull(rabatt));
                    b.setRechnungID(r.getRechnungID());

                    String[] kundenBuchungIDs = new String[kunde.getBuchungIDs().length + 1];
                    for(int i = 0; i < kunde.getBuchungIDs().length; i++){
                        kundenBuchungIDs[i] = kunde.getBuchungIDs()[i];
                    }
                    kundenBuchungIDs[kunde.getBuchungIDs().length] = b.getBuchungID();
                    kunde.setBuchungIDs(kundenBuchungIDs);

                    String[] mitarbeiterBuchungIDs = new String[mitarbeiter.getBuchungIDs().length + 1];
                    for(int i = 0; i < mitarbeiter.getBuchungIDs().length; i++){
                        mitarbeiterBuchungIDs[i] = mitarbeiter.getBuchungIDs()[i];
                    }
                    mitarbeiterBuchungIDs[mitarbeiter.getBuchungIDs().length] = b.getBuchungID();
                    mitarbeiter.setBuchungIDs(mitarbeiterBuchungIDs);


                    Carsharing.em.modify(Kunde.class, kunde.toStringArray());
                    Carsharing.em.modify(Mitarbeiter.class, mitarbeiter.toStringArray());
                    Carsharing.em.persistEl(Rechnung.class, r.toStringArray());
                    Carsharing.em.persistEl(Buchung.class, b.toStringArray());

                    refreshList();

                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(gui, "Die Eingabe ist nicht korrekt oder unvollständig ! \n Überprüfen Sie die eingegebenen Daten.");
                }

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);


                //Standort standort = (Standort) gui.standortDropDown.getSelectedItem();
                //String hersteller = gui.herstellerInput.getText();
                //String model = gui.modellInput.getText();
                //Fahrzeugklasse klasse = (Fahrzeugklasse) gui.klassenDropDown.getSelectedItem();
                //String kennzeichen = gui.kennzeichenInput.getText().toUpperCase();
                /*
                try {
                    int baujahr = Integer.parseInt(gui.baujahrInput.getText());
                    int kilometer = Integer.parseInt(gui.kilometerInput.getText());

                    FahrzeugBuilder fahrzeugBuilder = new FahrzeugBuilder();

                    fahrzeugBuilder.hersteller(hersteller);
                    fahrzeugBuilder.modell(model);
                    fahrzeugBuilder.baujahr(baujahr);
                    fahrzeugBuilder.kilometerstand(kilometer);
                    fahrzeugBuilder.status(true);
                    fahrzeugBuilder.klasse(((Fahrzeugklasse) Objects.requireNonNull(gui.klassenDropDown.getSelectedItem())).getName());

                    fahrzeugBuilder.standort("69");
                    fahrzeugBuilder.ausruestung(new String[]{});
                    fahrzeugBuilder.bilder(new String[]{});
                    fahrzeugBuilder.kennzeichen(kennzeichen);

                    //persist newly created vehicle
                    Fahrzeug newFahrzeug = fahrzeugBuilder.build();
                    Carsharing.em.persistEl(Fahrzeug.class, newFahrzeug.toStringArray());

                    //refresh list
                    refreshList();


                } catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(gui, "Die Eingabe ist nicht korrekt oder unvollständig ! \n Überprüfen Sie die eingegebenen Daten.");
                }

                 */
            } //Referenzen zu anderen Objekten!
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Cancel")){
                System.out.println("Es wurde Abbrechen geklickt");

                gui.startTerminPicker.getModel().setSelected(false);
                gui.endTerminPicker.getModel().setSelected(false);

                JPanel panel = gui.createRightSidePanel(-1);
                gui.createRightSide(panel);
                gui.setRightSiteVisible(panel);
                gui.clearListSelection(gui.buchungList);
            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Edit")){
                System.out.println("Es wurde Bearbeiten geklickt");

                JPanel panel = gui.createRightSidePanel(2);
                gui.createRightSide(panel);
                updateEditLabelTexts();
                gui.setRightSiteVisible(panel);



            }//Noch einige Funktionen ausstehend
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Loeschen")){
                System.out.println("Es wurde Löschen geklickt");

                Object[] options = {"Ja", "Nein"};

                int value1 = JOptionPane.showOptionDialog(
                        gui,
                        "Wollen Sie den Datensatz löschen?",
                        "Eintrag Löschen",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (value1 == 0){
                    int value2 = JOptionPane.showOptionDialog(
                            gui,
                            "Sind Sie sich sicher, dass Sie den Eintrag löschen wollen?",
                            "Eintrag Löschen",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);

                    if (value2 == 0){
                        int value3 = JOptionPane.showOptionDialog(
                                gui,
                                "Sind Sie sich ganz sicher, dass Sie den Eintrag löschen wollen?",
                                "Eintrag Löschen",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if(value3 == 0){
                            //Delete-Routine
                            Carsharing.em.removeEl(currentBuchung);
                            refreshList();
                        }
                    }
                }

            } //Funktion done
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Mahnung")){

                int anzahlMahnungen = currentBuchung.getMahnung().length;

                if(anzahlMahnungen == 1){
                    JOptionPane.showMessageDialog(gui, "Es liegt eine Mahnung vor!");
                } else {
                    JOptionPane.showMessageDialog(gui, "Es liegen zwei Mahnungen vor!");
                }
            } //Noch Objekte in Checkboxen einfügen
            if (((ButtonElement) guiEvent.getData()).getID().equals("Button-Save-Edit")){
                System.out.println("Es wurde Speichern beim Bearbeiten geklickt");

                checkZeitspanne();

                Fahrzeug fahrzeug = (Fahrzeug) gui.fahrzeugSelect.getSelectedItem();
                Date startTermin = (Date) gui.startTerminPicker.getModel().getValue();
                Date endTermin = (Date) gui.endTerminPicker.getModel().getValue();
                Kunde kunde = (Kunde) gui.kundeSelect.getSelectedItem();
                Mitarbeiter mitarbeiter = (Mitarbeiter) gui.mitarbeiterSelect.getSelectedItem();

                String fID = fahrzeug.getFahrzeugID();
                String kID = kunde.getKundeID();
                String mID = mitarbeiter.getMitarbeiterID();

                currentBuchung.setFahrzeug(fahrzeug);
                currentBuchung.setFahrzeugID(fID);

                currentBuchung.setStarttermin(startTermin);
                currentBuchung.setEndtermin(endTermin);

                Kunde k = currentBuchung.getKunde();
                k.setBuchungIDs(ArrayUtils.removeElement(k.getBuchungIDs(), currentBuchung.getBuchungID()));
                Carsharing.em.modify(Kunde.class, k.toStringArray());

                currentBuchung.setKunde(kunde);
                currentBuchung.setKundeID(kID);

                k = currentBuchung.getKunde();
                k.setBuchungIDs(ArrayUtils.add(k.getBuchungIDs(), currentBuchung.getBuchungID()));
                Carsharing.em.modify(Kunde.class, k.toStringArray());

                Mitarbeiter m = currentBuchung.getMitarbeiter();
                m.setBuchungIDs(ArrayUtils.removeElement(m.getBuchungIDs(), currentBuchung.getBuchungID()));
                Carsharing.em.modify(Mitarbeiter.class, m.toStringArray());

                currentBuchung.setMitarbeiter(mitarbeiter);
                currentBuchung.setMitarbeiterID(mID);

                m = currentBuchung.getMitarbeiter();
                m.setBuchungIDs(ArrayUtils.add(m.getBuchungIDs(), currentBuchung.getBuchungID()));
                Carsharing.em.modify(Mitarbeiter.class, m.toStringArray());

                Rechnung r = (Rechnung) Carsharing.em.find(Rechnung.class, currentBuchung.getRechnungID());
                Carsharing.em.removeEl(r);

                r  = Carsharing.ef.createRechnung(currentBuchung, r.getEvent());
                currentBuchung.setRechnungID(r.getRechnungID());
                Carsharing.em.persistEl(Rechnung.class, r.toStringArray());

                Carsharing.em.modify(Buchung.class, currentBuchung.toStringArray());



                /*
                currentBuchung.setKennzeichen(gui.kennzeichenInput.getText().toUpperCase());
                //Standort hinzufügen
                currentBuchung.setHersteller(gui.herstellerInput.getText());
                currentBuchung.setModell(gui.modellInput.getText());
                currentBuchung.setFahrzeugklasse((Fahrzeugklasse) gui.klassenDropDown.getSelectedItem());
                currentBuchung.setBaujahr(Integer.parseInt(gui.baujahrInput.getText()));
                currentBuchung.setKilometerstand(Integer.parseInt(gui.kilometerInput.getText()));
                //Reifensatz hinzufügen
                //Ausrüstung hinzufügen

                Carsharing.em.modify(Fahrzeug.class, currentBuchung.toStringArray());
                 */
                refreshList();
            } //Noch einige Askepte ausstehend
        }
    }

    public void updateDetailLabelTexts(){

        gui.fahrzeugLabel.setText(currentBuchung.getFahrzeug().getHersteller() + " " + currentBuchung.getFahrzeug().getModell());

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentBuchung.getStarttermin());
        int start_year = calendar.get(Calendar.YEAR);
        int start_month = calendar.get(Calendar.MONTH) + 1;
        int start_day = calendar.get(Calendar.DAY_OF_MONTH);

        String startString = start_day + "." + start_month + "." + start_year;

        calendar.setTime(currentBuchung.getEndtermin());
        int end_year = calendar.get(Calendar.YEAR);
        int end_month = calendar.get(Calendar.MONTH) + 1;
        int end_day = calendar.get(Calendar.DAY_OF_MONTH);

        String endString = end_day + "." + end_month + "." + end_year;

        gui.startLabel.setText(startString);
        gui.endLabel.setText(endString);
        gui.klasseLabel.setText(currentBuchung.getFahrzeug().getFahrzeugklasse().getName());
        gui.preisLabel.setText(String.valueOf(((Rechnung) Carsharing.em.find(Rechnung.class,currentBuchung.getRechnungID())).getBetrag()));
        gui.kundeLabel.setText(currentBuchung.getKunde().getNachname() + ", " + currentBuchung.getKunde().getVorname());
        gui.mitarbeiterLabel.setText(currentBuchung.getMitarbeiter().getNachname() + ", " + currentBuchung.getMitarbeiter().getVorname());

        gui.rabattLabel.setText(String.valueOf(((Rechnung) Carsharing.em.find(Rechnung.class, currentBuchung.getRechnungID())).getEvent()));

        if(!currentBuchung.getMahnungIDs()[0].equals("")){
            gui.mahnungButton.setEnabled(false);
        }

    }

    private void updateEditLabelTexts(){

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentBuchung.getStarttermin());
        int start_year = calendar.get(Calendar.YEAR);
        int start_month = calendar.get(Calendar.MONTH) + 1;
        int start_day = calendar.get(Calendar.DAY_OF_MONTH);


        calendar.setTime(currentBuchung.getEndtermin());
        int end_year = calendar.get(Calendar.YEAR);
        int end_month = calendar.get(Calendar.MONTH) + 1;
        int end_day = calendar.get(Calendar.DAY_OF_MONTH);

        gui.startTerminPicker.getModel().setDate(start_year, start_month, start_day);
        gui.endTerminPicker.getModel().setDate(end_year, end_month, end_day);
        gui.startTerminPicker.getModel().setSelected(true);
        gui.endTerminPicker.getModel().setSelected(true);

        int fahrzeugIndex = 0;
        int kundeIndex = 0;
        int mitarbeiterIndex = 0;


        Fahrzeug[] fzTmp = this.loadFahrzeugModel();
        for(int i = 0; i < fzTmp.length; i++){
            if(fzTmp[i].getFahrzeugID().equals(currentBuchung.getFahrzeugID())){
                fahrzeugIndex = i;
            }
        }

        Kunde[] kTmp = this.loadKundeModel();
        for(int i = 0; i < kTmp.length; i++){
            if(kTmp[i].getKundeID().equals(currentBuchung.getKundeID())){
                kundeIndex = i;
            }
        }

        Mitarbeiter[] mTmp = this.loadMitarbeiterModel();
        for(int i = 0; i < mTmp.length; i++){
            if(mTmp[i].getMitarbeiterID().equals(currentBuchung.getMitarbeiterID())){
                mitarbeiterIndex = i;
            }
        }


        gui.fahrzeugSelect.setSelectedIndex(fahrzeugIndex);
        gui.kundeSelect.setSelectedIndex(kundeIndex);
        gui.mitarbeiterSelect.setSelectedIndex(mitarbeiterIndex);



    }

    public Fahrzeug[] loadFahrzeugModel(){
        List<Object> data = Carsharing.em.getAllEl(Fahrzeug.class);
        List<Fahrzeug> fahrzeugList = new ArrayList<>();


        for(int i = 0; i < data.size(); i++){
            Fahrzeug f = (Fahrzeug) data.get(i);
            if(f.isStatus()){
                fahrzeugList.add(f);
            }
        }

        Fahrzeug[] fahrzeugArr = new Fahrzeug[fahrzeugList.size()];

        for(int i = 0; i < fahrzeugList.size(); i++){
                fahrzeugArr[i] = fahrzeugList.get(i);
        }

        return fahrzeugArr;
    }

    public Kunde[] loadKundeModel(){
        List<Object> data = Carsharing.em.getAllEl(Kunde.class);
        Kunde[] kundeList = new Kunde[data.size()];

        for(int i = 0; i < data.size(); i++){
            kundeList[i] = (Kunde) data.get(i);
        }

        return kundeList;
    }

    public Mitarbeiter[] loadMitarbeiterModel(){
        List<Object> data = Carsharing.em.getAllEl(Mitarbeiter.class);
        Mitarbeiter[] mitarbeiterList = new Mitarbeiter[data.size()];

        for(int i = 0; i < data.size(); i++){
            mitarbeiterList[i] = (Mitarbeiter) data.get(i);
        }

        return mitarbeiterList;
    }

    public Rabattaktion[] loadRabattModel(){
        List<Object> data = Carsharing.em.getAllEl(Rabattaktion.class);
        Rabattaktion[] rabattList = new Rabattaktion[data.size()];

        for(int i = 0; i < data.size(); i++){
            rabattList[i] = (Rabattaktion) data.get(i);
        }

        return rabattList;
    }

    private boolean checkAll(){

        boolean zeitInput = checkZeitspanne();

        if(zeitInput) return true;
        else return false;

    }

    private boolean checkZeitspanne(){

        Date startTermin = (Date) gui.startTerminPicker.getModel().getValue();
        Date endTermin = (Date) gui.endTerminPicker.getModel().getValue();
        int resZeitspanne = startTermin.compareTo(endTermin);

        if (resZeitspanne > 0) {
            JOptionPane.showMessageDialog(gui, "Der Endtermin ist vor dem Startdatum. \n Bitte überprüfen Sie die Eingabe!");
            return false;
        }

        LocalDate today = LocalDate.now();
        int resVergangenheit = startTermin.compareTo(Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        if (resVergangenheit < 0){
            JOptionPane.showMessageDialog(gui, "Der Starttermin liegt in der Vergangenheit. \n Bitte überprüfen Sie die Eingabe!");
            return false;
        }

        return true;
    }

    private void refreshList(){
        gui.buchungList.setListElements(this.loadData());
    }


    public String loadRabattBeschreibung() {
        return ((Rechnung) Carsharing.em.find(Rechnung.class,currentBuchung.getRechnungID())).getEvent().toString();
    }
}
