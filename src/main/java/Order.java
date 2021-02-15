public class Order {

    private final Parcel parcel;
    private final boolean speedyShipping;

    public Order(Parcel parcel, boolean speedyShipping) {
        this.parcel = parcel;
        this.speedyShipping = speedyShipping;
    }

    public Parcel getParcel() {
        return parcel;
    }

    /**
     * totalPrice is 2 * shippingPrice if speedyShipping is selected
     * @return
     */
    public int totalPrice() {
        return shippingPrice() + speedyShippingPrice();
    }


    public int shippingPrice() {
        return parcel.cost();
    }


    public int speedyShippingPrice() {
        if (speedyShipping) {
            return shippingPrice();
        }
        else return 0;
    }

    public String shippingInfo() {
       return "Order: " + "\n" +
               "parcel= " + parcel + "\n" +
               "Shipping price= " + shippingPrice() + "\n";
    }

    public String speedyShippingInfo() {
        return "Speedy Shipping price=" + speedyShippingPrice() + "\n";
    }

    @Override
    public String toString() {

        if (speedyShipping) {
            return shippingInfo() + speedyShippingInfo();
        }
        return shippingInfo();
    }
}
