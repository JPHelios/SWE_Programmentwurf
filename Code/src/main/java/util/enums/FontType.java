package util.enums;

public enum FontType {

    ARIAL("Arial"),
    TIMES_NEW_ROMAN("Times New Roman"),
    HELVETICA("Helvetica");
    //Hier können weitere Schriftarten hinzugefügt werden

    private final String fontType;

    private FontType(final String fontType){
        this.fontType = fontType;
    }

    @Override
    public String toString(){
        return fontType;
    }

    public String getFontArray(){
        return null;
    }
}
