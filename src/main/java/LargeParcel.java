public class LargeParcel extends Parcel {

    public LargeParcel(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public int cost() {
        return 15;
    }
}