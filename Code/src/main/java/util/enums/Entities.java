package util.enums;


public enum Entities {
    Buchung("src\\main\\resources\\database\\buchung.csv", new String[]{""}),
    Mahnung("src\\main\\resources\\database\\mahnung.csv", new String[]{""}),
    Rabattaktion("src\\main\\resources\\database\\rabattaktion.csv", new String[]{""}),
    Rechnung("src\\main\\resources\\database\\rechnung.csv", new String[]{""}),
    Dachbox("src\\main\\resources\\database\\dachbox.csv", new String[]{""}),
    Fahrradtraeger("src\\main\\resources\\database\\fahrradtraeger.csv", new String[]{""}),
    Fahrzeug("src\\main\\resources\\database\\fahrzeug.csv", new String[]{""}),
    Fahrzeugklasse("src\\main\\resources\\database\\fahrzeugklasse.csv", new String[]{""}),
    Hundetransportbox("src\\main\\resources\\database\\hundetransportbox.csv", new String[]{""}),
    Kennzeichen("src\\main\\resources\\database\\kennzeichen.csv", new String[]{""}),
    Reifen("src\\main\\resources\\database\\reifen.csv", new String[]{""}),
    Reifensatz("src\\main\\resources\\database\\reifensatz.csv", new String[]{""}),
    Kunde("src\\main\\resources\\database\\kunde.csv", new String[]{""}),
    Vertrag("src\\main\\resources\\database\\vertrag.csv", new String[]{""}),
    Filiale("src\\main\\resources\\database\\filiale.csv", new String[]{""}),
    Mitarbeiter("src\\main\\resources\\database\\mitarbeiter.csv", new String[]{""}),
    Rolle("src\\main\\resources\\database\\rolle.csv", new String[]{""}),
    Standort("src\\main\\resources\\database\\standort.csv", new String[]{"Standort-ID", "Anzahl Stellplätze", "Anzahl E-Säulen", "Bild-ID", "Adress-ID"}),
    Adresse("src\\main\\resources\\database\\adresse.csv", new String[]{""}),
    Backup("src\\main\\resources\\database\\backup.csv", new String[]{""}),
    Bild("src\\main\\resources\\database\\bild.csv", new String[]{""});



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
