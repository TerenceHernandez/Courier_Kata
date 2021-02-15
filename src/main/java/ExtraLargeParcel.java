public class ExtraLargeParcel extends Parcel {

    public static int baseCost = 25;
    public static int weightLimit = 10;
    public static int overWeightPrice = 2;

    public ExtraLargeParcel(int length, int width, int height, int weight) {
        super(length, width, height, weight, baseCost, overWeightPrice, weightLimit);
    }
}