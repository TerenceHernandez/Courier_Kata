public class MediumParcel extends Parcel {

    public static int baseCost = 8;
    public static int weightLimit = 3;
    public static int overWeightPrice = 2;

    public MediumParcel(int weight) {
        super(weight, baseCost, overWeightPrice, weightLimit);
    }

    @Override
    public String toString() {
        if (isDiscounted()) {
            return "Medium Parcel: $0\n";
        }
        return "Medium Parcel: $" + cost() + '\n';
    }
}
