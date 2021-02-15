public class LargeParcel extends Parcel {

    public static int baseCost = 15;
    public static int weightLimit = 6;
    public static int overWeightPrice = 2;

    public LargeParcel(int length, int width, int height, int weight) {
        super(length, width, height, weight, baseCost, overWeightPrice, weightLimit);
    }
}