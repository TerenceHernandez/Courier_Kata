public class Order {

    private Parcel parcel;
    private boolean speedyShipping;

    public Order(Parcel parcel, boolean speedyShipping) {
        this.parcel = parcel;
        this.speedyShipping = speedyShipping;
    }

    public int totalPrice() {
        if (speedyShipping) {
            return 2 * parcel.cost();
        }
        return parcel.cost();
    }
}
