package util.enums;


import app.Carsharing;

public enum Entities {
    Buchung(Carsharing.dirPath +"database\\buchung.csv", new String[]{"Buchung-ID", "Canceled", "Starttermin", "Endtermin", "Fahrzeug-ID", "Rechnung-ID", "Mahnung-IDs", "Kunde-ID", "Mitarbeiter-ID"}),
    Mahnung(Carsharing.dirPath +"database\\mahnung.csv", new String[]{"Mahnung-ID", "Betrag", "Fälligkeitsdatum", "Anzahl", "Buchung-ID"}),
    Rabattaktion(Carsharing.dirPath +"database\\rabattaktion.csv", new String[]{"Rabattaktion-ID", "Preisnachlass", "Beschreibung", "Aktionsklassen"}),
    Rechnung(Carsharing.dirPath +"database\\rechnung.csv", new String[]{"Rechnung-ID","Betrag", "Fälligkeitsdatum", "Pfad", "Buchung-ID", "Rabattaktion-ID"}),
    Dachbox(Carsharing.dirPath +"database\\dachbox.csv", new String[]{"Dachbox-ID", "Volumen", "Höhe", "Name", "Beschreibung", "kompatibel-IDs", "Fahrzeug-ID"}),
    Fahrradtraeger(Carsharing.dirPath +"database\\fahrradtraeger.csv", new String[]{"Fahrradträger-ID", "Anzahl-Fahrräder", "Montierung", "Maximalgewicht", "Name", "Beschreibung", "kompatibel", "Fahrzeug-ID"}),
    Fahrzeug(Carsharing.dirPath +"database\\fahrzeug.csv", new String[]{"Fahrzeug-ID", "Hersteller", "Modell", "Baujahr", "Status", "Kilometerstand", "Reserviert", "Kennzeichen", "Ausrüstung-IDs", "Reifensatz-ID", "Standort-ID", "Bild-IDs", "Fahrzeugklasse-ID"}),
    Hundetransportbox(Carsharing.dirPath +"database\\hundetransportbox.csv", new String[]{"Hundetransportbox-ID", "Hundekompatibilität", "AnzahlHunde", "Beschreibung", "Name", "FahrzeugKompatibilität-IDs", "Fahrzeug-ID"}),
    Reifen(Carsharing.dirPath +"database\\reifen.csv", new String[]{"Reifen-ID", "Hersteller", "Modell", "Baujahr", "Typ"}),
    Reifensatz(Carsharing.dirPath +"database\\reifensatz.csv", new String[]{"Reifensatz-ID", "Reifen-IDs", "Ersatzrad-ID"}),
    Kunde(Carsharing.dirPath +"database\\kunde.csv", new String[]{"Kunde-ID", "Nachname", "Vorname", "Telefon", "Mail", "Vertrag-ID", "Adresse-ID", "Buchung-IDs"}),
    Vertrag(Carsharing.dirPath +"database\\vertrag.csv", new String[]{"Vertrag-ID", "Pfad", "Datum", "Kunde-ID"}),
    Filiale(Carsharing.dirPath +"database\\filiale.csv", new String[]{"Filiale-ID", "Öffnungszeiten", "Mitarbeiter-IDs", "Standort-ID"}),
    Mitarbeiter(Carsharing.dirPath +"database\\mitarbeiter.csv", new String[]{"Mitarbeiter-ID", "Nachname", "Vorname", "Telefon", "Mail", "Passwort", "Rolle-ID", "Filiale-ID", "Backup-IDs", "Buchung-IDs"}),
    Rolle(Carsharing.dirPath +"database\\rolle.csv", new String[]{"Rolle-ID", "Bezeichnung", "Berechtigt"}),
    Standort(Carsharing.dirPath +"database\\standort.csv", new String[]{"Standort-ID", "Anzahl Stellplätze", "Anzahl E-Säulen","Fahrzeug-IDs", "Filialen-IDs", "Bild-ID", "Adress-ID"}),
    Adresse(Carsharing.dirPath +"database\\adresse.csv", new String[]{"Adresse-ID", "Straße", "Hausnummer", "PLZ", "Ort", "Zusatz"}),
    Backup(Carsharing.dirPath +"database\\backup.csv", new String[]{"Backup-ID", "Pfad", "Mitarbeiter-ID"}),
    Bild(Carsharing.dirPath +"database\\bild.csv", new String[]{"Bild-ID", "Pfad", "Titel"});

    private String path;
    String[] header;

    Entities(String path, String[] header) {
        this.path = path;
        this.header = header;
    }

    public String getPath() {
        return path;
    }

    public String[] getHeader() {
        return header;
    }
}
