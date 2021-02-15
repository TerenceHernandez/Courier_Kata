import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Parcel> parcels = new ArrayList<>();
    private boolean speedyShipping;

    public Order(Parcel parcel, boolean speedyShipping) {
        this.parcels.add(parcel);
        this.speedyShipping = speedyShipping;
    }

    public Order() { }

    public Order(List<Parcel> parcels, boolean speedyShipping) {
        this.parcels.addAll(parcels);
        this.speedyShipping = speedyShipping;
    }

    /**
     * totalPrice is 2 * shippingPrice if speedyShipping is selected
     * @return
     */
    public int totalPrice() {
        return shippingPrice() + speedyShippingPrice();
    }


    public int shippingPrice() {
        int totalParcelCost = 0;

        for (Parcel p : parcels) {
            if (!p.isDiscounted()) {
                totalParcelCost += p.cost();
            }
        }

        return totalParcelCost;
    }


    public int speedyShippingPrice() {
        if (speedyShipping) {
            return shippingPrice();
        }
        else return 0;
    }

    public String shippingInfo() {
       return "Order: " + "\n" +
               "parcel= " + parcels + "\n" +
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

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void add(Parcel parcel) {
        parcels.add(parcel);
    }
}
