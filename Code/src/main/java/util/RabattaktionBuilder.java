package util;

import model.buchung.Rabattaktion;

public class RabattaktionBuilder {
    private Rabattaktion r;

    public RabattaktionBuilder(){
        r = new Rabattaktion();
    }

    public RabattaktionBuilder rabatt(int rab){
        r.setPreisnachlass(rab);
        return this;
    }

    public RabattaktionBuilder beschreibung(String b){
        r.setBeschreibung(b);
        return this;
    }

    public Rabattaktion build(){
        return r;
    }
}
