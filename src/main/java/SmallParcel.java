public class SmallParcel extends Parcel{

    public SmallParcel(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public int cost() {
        return 3;
    }
}
