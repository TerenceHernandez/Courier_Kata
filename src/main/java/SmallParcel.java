public class SmallParcel extends Parcel{

    public static int baseCost = 3;
    public static int weightLimit = 1;

    public SmallParcel(int length, int width, int height, int weight) {
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
