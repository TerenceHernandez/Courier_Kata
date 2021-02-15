public class Parcel {

    private final int length;
    private final int width;
    private final int height;

    public Parcel(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int cost() {
        int maxDim = getMaxDimension();
        if (maxDim < 10) {
            return 3;
        } else if (maxDim < 50) {
            return 8;
        } else if (maxDim < 100) {
            return 15;
        } else {
            return 25;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    private int getMaxDimension() {
        return Math.max(getHeight(), Math.max(getLength(), getWidth()));
    }
}