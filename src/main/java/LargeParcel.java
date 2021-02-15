public class LargeParcel extends Parcel {

    public static int baseCost = 15;
    public static int weightLimit = 6;

    public LargeParcel(int length, int width, int height, int weight) {
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