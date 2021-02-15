public class MediumParcel extends Parcel {

    public static int baseCost = 8;
    public static int weightLimit = 3;
    public static int overWeightPrice = 2;

    public MediumParcel(int length, int width, int height, int weight) {
        super(length, width, height, weight, baseCost, overWeightPrice, weightLimit);
    }
}
