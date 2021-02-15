public class HeavyParcel extends Parcel {

    public static int baseCost = 50;
    public static int weightLimit = 50;
    public static int overWeightPrice = 1;

    public HeavyParcel(int weight) {
        super(weight, baseCost, overWeightPrice, weightLimit);
    }

}
