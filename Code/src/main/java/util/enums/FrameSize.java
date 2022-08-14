package util.enums;

public enum FrameSize {

    WINDOW_SMALL(1280, 720),
    WINDOW_MEDIUM(1600, 900),
    WINDOW_LARGE(1920, 1080),
    WINDOW_XLARGE(2560, 1440);

    private final int x;
    private final int y;

    private FrameSize(final int x, final int y){
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
