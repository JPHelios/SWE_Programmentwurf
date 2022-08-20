package util.enums;

public enum FrameSize {

    WINDOW_SMALL("Klein",1280, 720),
    WINDOW_MEDIUM("Mittel",1600, 900),
    WINDOW_LARGE("Groß",1920, 1080),
    WINDOW_XLARGE("Sehr Groß",2560, 1440);

    private final String description;
    private final int x;
    private final int y;

    private FrameSize(final String description, final int x, final int y){
        this.description = description;
        this.x = x;
        this.y = y;
    }

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

}
