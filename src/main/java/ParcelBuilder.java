public class ParcelBuilder {
    private int length = 0;
    private int width = 0;
    private int height = 0;
    private int weight = 0;

    private ParcelBuilder(){}

    public Parcel build() {
        if (weight >= 50) {
            return new HeavyParcel(weight);
        }
        else if (maxDim() < 10) {
            return new SmallParcel(weight);
        } else if (maxDim() < 50) {
            return new MediumParcel(weight);
        } else if (maxDim() < 100) {
            return new LargeParcel(weight);
        } else {
            return new ExtraLargeParcel(weight);
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

    public ParcelBuilder withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    private int maxDim() {
        return Math.max(Math.max(width, height), length);
    }
}
