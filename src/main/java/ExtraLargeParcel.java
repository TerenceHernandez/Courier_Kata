public class ExtraLargeParcel extends Parcel {

    public static int baseCost = 25;
    public static int weightLimit = 10;
    public static int overWeightPrice = 2;

    public ExtraLargeParcel(int weight) {
        super(weight, baseCost, overWeightPrice, weightLimit);
    }

    @Override
    public String toString() {
        if (isDiscounted()) {
            return "Extra Large Parcel: $0\n";
        }
        return "Extra Large Parcel: $" + cost() + '\n';
    }
}