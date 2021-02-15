import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Parcel> parcels = new ArrayList<>();
    private boolean speedyShipping;

    /**
     * A customers' order regarding a single or multiple parcels
     * @param parcel - A single parcel in an order, @field params denotes ALL parcels in the order
     * @param speedyShipping - Indicates if an order is subscribed to speedy shipping
     */
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

    public String parcelInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("parcels = \n");
        for (Parcel p : parcels) {
            sb.append(p.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String shippingInfo() {
       return "Order: " + "\n" +
               parcelInfo() +
               "Shipping price = $" + shippingPrice() + "\n";
    }

    public String speedyShippingInfo() {
        return "Speedy Shipping price = $" + speedyShippingPrice() + "\n";
    }

    public String totalPriceInfo() {
        return "Total price = $" + totalPrice() + "\n";
    }

    @Override
    public String toString() {

        if (speedyShipping) {
            return shippingInfo() + speedyShippingInfo() + totalPriceInfo();
        }
        return shippingInfo() + totalPriceInfo();
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void add(Parcel parcel) {
        parcels.add(parcel);
    }
}
