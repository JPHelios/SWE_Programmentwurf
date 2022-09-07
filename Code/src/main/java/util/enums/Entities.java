package util.enums;


public enum Entities {
    Buchung("src\\main\\resources\\database\\buchung.csv", new String[]{"Buchung-ID", "Canceled", "Starttermin", "Endtermin", "Fahrzeug-ID", "Rechnung-ID", "Mahnung-IDs", "Kunde-ID", "Mitarbeiter-ID"}),
    Mahnung("src\\main\\resources\\database\\mahnung.csv", new String[]{"Mahnung-ID", "Betrag", "Fälligkeitsdatum", "Anzahl", "Buchung-ID"}),
    Rabattaktion("src\\main\\resources\\database\\rabattaktion.csv", new String[]{"Rabattaktion-ID", "Preisnachlass", "Beschreibung", "Aktionsklassen"}),
    Rechnung("src\\main\\resources\\database\\rechnung.csv", new String[]{"Rechnung-ID", "Fälligkeitsdatum", "Pfad", "Buchung-ID", "Rabattaktion-ID"}),
    Dachbox("src\\main\\resources\\database\\dachbox.csv", new String[]{"Dachbox-ID", "Volumen", "Höhe", "Name", "Beschreibung", "kompatibel-IDs", "Fahrzeug-ID"}),
    Fahrradtraeger("src\\main\\resources\\database\\fahrradtraeger.csv", new String[]{"Fahrradträger-ID", "Anzahl-Fahrräder", "Montierung", "Maximalgewicht", "Name", "Beschreibung", "kompatibel", "Fahrzeug-ID"}),
    Fahrzeug("src\\main\\resources\\database\\fahrzeug.csv", new String[]{"Fahrzeug-ID", "Hersteller", "Modell", "Baujahr", "Status", "Kilometerstand", "Reserviert", "Kennzeichen-ID", "Ausrüstung-IDs", "Reifensatz-ID", "Standort-ID", "Bild-IDs", "Fahrzeugklasse-ID"}),
    Fahrzeugklasse("src\\main\\resources\\database\\fahrzeugklasse.csv", new String[]{"Fahrzeugklasse-ID", "Name", "Preis", "Beschreibung", "Führerschein", "Fahrzeug-IDs"}),
    Hundetransportbox("src\\main\\resources\\database\\hundetransportbox.csv", new String[]{"Hundetransportbox-ID", "Hundekompatibilität", "AnzahlHunde", "Beschreibung", "Name", "FahrzeugKompatibilität-IDs", "Fahrzeug-ID"}),
    Kennzeichen("src\\main\\resources\\database\\kennzeichen.csv", new String[]{"Kennzeichen-ID", "Kennzeichen", "Zulassungsstelle"}),
    Reifen("src\\main\\resources\\database\\reifen.csv", new String[]{"Reifen-ID", "Hersteller", "Modell", "Baujahr", "Typ"}),
    Reifensatz("src\\main\\resources\\database\\reifensatz.csv", new String[]{"Reifensatz-ID", "Reifen-IDs", "Ersatzrad-ID"}),
    Kunde("src\\main\\resources\\database\\kunde.csv", new String[]{"Kunde-ID", "Nachname", "Vorname", "Telefon", "Mail", "Vertrag-ID", "Adresse-ID", "Buchung-IDs"}),
    Vertrag("src\\main\\resources\\database\\vertrag.csv", new String[]{"Vertrag-ID", "Pfad", "Datum", "Kunde-ID"}),
    Filiale("src\\main\\resources\\database\\filiale.csv", new String[]{"Filiale-ID", "Öffnungszeiten", "Mitarbeiter-IDs", "Standort-ID"}),
    Mitarbeiter("src\\main\\resources\\database\\mitarbeiter.csv", new String[]{"Mitarbeiter-ID", "Nachname", "Vorname", "Telefon", "Mail", "Passwort", "Rolle-ID", "Filiale-ID", "Backup-IDs", "Buchung-IDs"}),
    Rolle("src\\main\\resources\\database\\rolle.csv", new String[]{"Rolle-ID", "Bezeichnung", "Berechtigt"}),
    Standort("src\\main\\resources\\database\\standort.csv", new String[]{"Standort-ID", "Anzahl Stellplätze", "Anzahl E-Säulen", "Bild-ID", "Adress-ID"}),
    Adresse("src\\main\\resources\\database\\adresse.csv", new String[]{"Adresse-ID", "Straße", "Hausnummer", "PLZ", "Ort", "Zusatz"}),
    Backup("src\\main\\resources\\database\\backup.csv", new String[]{"Backup-ID", "Pfad", "Mitarbeiter-ID"}),
    Bild("src\\main\\resources\\database\\bild.csv", new String[]{"Bild-ID", "Pfad", "Titel"});



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
