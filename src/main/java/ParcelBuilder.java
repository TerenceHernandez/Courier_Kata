public class ParcelBuilder {
    private int length = 0;
    private int width = 0;
    private int height = 0;

    private ParcelBuilder(){}

    public Parcel build() {
        if (maxDim() < 10) {
            return new SmallParcel(length, width, height);
        } else if (maxDim() < 50) {
            return new MediumParcel(length, width, height);
        } else if (maxDim() < 100) {
            return new LargeParcel(length, width, height);
        } else {
            return new ExtraLargeParcel(length, width, height);
        }
    }

    public static ParcelBuilder aParcel() {
        return new ParcelBuilder();
    }

    public ParcelBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public ParcelBuilder withHeight(int height) {
        this.height = height;
        return this;
    }

    public ParcelBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    private int maxDim() {
        return Math.max(Math.max(width, height), length);
    }
}
