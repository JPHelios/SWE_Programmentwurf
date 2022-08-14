package util.enums;

public enum TextSize {

    TEXT_SIZE_SMALL(7,10),
    TEXT_SIZE_MEDIUM(10,13),
    TEXT_SIZE_LARGE(13, 16),
    TEXT_SIZE_XLARGE(15,20);

    private final int labelSize;
    private final int textSize;

    private TextSize(final int labelSize, final int textSize) {
        this.labelSize = labelSize;
        this.textSize = textSize;
    }

    public int label(){
        return labelSize;
    }

    public int text(){
        return textSize;
    }
}
