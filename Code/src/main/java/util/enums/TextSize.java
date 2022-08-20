package util.enums;

public enum TextSize {

    TEXT_SIZE_SMALL(7,10, 25),
    TEXT_SIZE_MEDIUM(10,13, 33),
    TEXT_SIZE_LARGE(13, 16, 40),
    TEXT_SIZE_XLARGE(15,20, 50);

    private final int labelSize;
    private final int textSize;
    private final int headlineSize;

    private TextSize(final int labelSize, final int textSize, final int headlineSize) {
        this.labelSize = labelSize;
        this.textSize = textSize;
        this.headlineSize = headlineSize;
    }

    public int label(){
        return labelSize;
    }

    public int text(){
        return textSize;
    }

    public int headline() {return headlineSize; }
}
