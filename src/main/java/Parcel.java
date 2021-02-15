abstract class Parcel {

    private final int length;
    private final int width;
    private final int height;

    public Parcel(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    abstract public int cost();

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    protected int getMaxDimension() {
        return Math.max(getHeight(), Math.max(getLength(), getWidth()));
    }
}