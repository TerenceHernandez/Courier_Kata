public class SmallParcel extends Parcel{

    public static int baseCost = 3;
    public static int weightLimit = 1;
    public static int overWeightPrice = 2;

    public SmallParcel(int length, int width, int height, int weight) {
        super(length, width, height, weight, baseCost, overWeightPrice, weightLimit);
    }

}
