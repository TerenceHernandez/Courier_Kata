public class HeavyParcel extends Parcel {

    public static int baseCost = 50;
    public static int weightLimit = 50;
    public static int overWeightPrice = 1;

    public HeavyParcel(int weight) {
        super(weight, baseCost, overWeightPrice, weightLimit);
    }

    @Override
    public String toString() {
        if (isDiscounted()) {
            return "Heavy Parcel: 0\n";
        }
        return "Heavy Parcel: " + cost() + '\n';
    }
}
