public class LargeParcel extends Parcel {

    public static int baseCost = 15;
    public static int weightLimit = 6;
    public static int overWeightPrice = 2;

    public LargeParcel(int weight) {
        super(weight, baseCost, overWeightPrice, weightLimit);
    }

    @Override
    public String toString() {
        if (isDiscounted()) {
            return "Large Parcel: $0\n";
        }
        return "Large Parcel: $" + cost() + '\n';
    }
}