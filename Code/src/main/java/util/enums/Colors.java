package util.enums;

import java.awt.*;

public enum Colors {

    PALE_VIOLET_RED(222,99,154),
    CADILLAC_PINK(227,136,177),
    PINK_ROSE(215,166,179),
    PINK_MERCURY(241, 226, 226),
    SMOKEY_GREY(112,112,112);

    private final int r;
    private final int g;
    private final int b;

    private Colors(final int r, final int g, final int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color getColor(){
        return new Color(r,g,b);
    }

}
