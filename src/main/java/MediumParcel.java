public class MediumParcel extends Parcel {

    public static int baseCost = 8;
    public static int weightLimit = 3;

    public MediumParcel(int length, int width, int height, int weight) {
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
