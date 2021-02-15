public class ExtraLargeParcel extends Parcel {

    public ExtraLargeParcel(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public int cost() {
        return 25;
    }
}