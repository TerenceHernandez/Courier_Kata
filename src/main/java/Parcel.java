abstract class Parcel {

    private final int length;
    private final int width;
    private final int height;
    private int weight;

    public static final int overWeightPrice = 2;

    public Parcel(int length, int width, int height, int weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
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

    public int getWeight() {
        return weight;
    }

    protected int getMaxDimension() {
        return Math.max(getHeight(), Math.max(getLength(), getWidth()));
    }
}