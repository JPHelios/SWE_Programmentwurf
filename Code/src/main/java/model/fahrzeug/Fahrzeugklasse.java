package model.fahrzeug;

import lombok.Data;

public enum Fahrzeugklasse {

    TRANSPORTER(1, "Transporter", 20, "B"),
    KLEINWAGEN(2, "Kleinwagen", 10, "B"),
    SPORTWAGEN(3, "Sportwagen", 25, "B"),
    HYBRID(4, "Hybrid", 15, "B");

    private final int id;
    private final String name;
    private final float preis;
    private final String fuehrerschein;

    private Fahrzeugklasse(final int id, final String name, final float preis, final String fuehrerschein){
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.fuehrerschein = fuehrerschein;
    }

    public String getName(){
        return name;
    }

    public float getPreis(){
        return preis;
    }

}
