public class ExtraLargeParcel extends Parcel {

    public static int baseCost = 25;
    public static int weightLimit = 10;

    public ExtraLargeParcel(int length, int width, int height, int weight) {
        super(length, width, height, weight);
    }

    @Override
    public int cost() {
        if (getWeight() > weightLimit) {
            return baseCost + (getWeight() - weightLimit) * Parcel.overWeightPrice;
        }

        return baseCost;
    }
}