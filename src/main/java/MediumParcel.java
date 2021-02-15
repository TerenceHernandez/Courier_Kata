public class MediumParcel extends Parcel {

    public MediumParcel(int length, int width, int height) {
        super(length, width, height);
    }

    @Override
    public int cost() {
        return 8;
    }
}
