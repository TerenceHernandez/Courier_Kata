import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountApplier {

    private static int smallParcelManiaIndex = 3;
    private static int mediumParcelManiaIndex = 2;
    private static int mixedParcelManiaIndex = 4;

    private Order order;

    public DiscountApplier(Order order) {
        this.order = order;
    }

    private Parcel smallParcelMania() {
        List<Parcel> parcels = order.getParcels();

        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof SmallParcel).collect(Collectors.toList()); // Need to add check for isDiscounted

        List<Parcel> discounted = new ArrayList<>();
        for (int i = smallParcelManiaIndex; i < smallParcels.size(); i += smallParcelManiaIndex) {
            discounted.add(smallParcels.get(i));
        }
        System.out.println(discounted);

        return cheapestParcel(discounted);
    }

    private Parcel cheapestParcel(List<Parcel> discounted) {
        // If there are no discounted parcels, just return a dummy parcel that isn't connected to any order
        if (discounted.isEmpty()) {
            return ParcelBuilder.aParcel().build();
        }

        Parcel cheapestParcel = discounted.get(0);

        for (Parcel p : discounted) {
            if (p.cost() < cheapestParcel.cost()) {
                cheapestParcel = p;
            }
        }
        System.out.println(cheapestParcel);
        return cheapestParcel;
    }

    public void apply() {
        Parcel p = smallParcelMania();
        p.applyDiscount();
    }
}
