import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountApplier {

    public static int smallParcelManiaIndex = 3;
    public static int mediumParcelManiaIndex = 2;
    public static int mixedParcelManiaIndex = 4;

    private Order order;

    /**
     * A wrapper around an Order to apply the discounts currently supplied by the courier
     * @param order
     */
    public DiscountApplier(Order order) {
        this.order = order;
    }

    private Parcel smallParcelMania(List<Parcel> parcels) {
        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof SmallParcel).collect(Collectors.toList());

        return parcelMania(smallParcelManiaIndex, smallParcels);
    }

    private Parcel mediumParcelMania(List<Parcel> parcels) {
        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof MediumParcel).collect(Collectors.toList());
        return parcelMania(mediumParcelManiaIndex, smallParcels);
    }

    private Parcel mixedParcelMania(List<Parcel> parcels) {

        return parcelMania(mixedParcelManiaIndex, parcels);
    }

    /**
     *
     * @param everyIndex - The item at which the discount is applied at intervals
     * @param eligibleParcels - The parcels in an order that are eligible for the discount
     * @return - The CHEAPEST parcel that satisfies the discount
     */
    private Parcel parcelMania(int everyIndex, List<Parcel> eligibleParcels) {

        List<Parcel> discounted = new ArrayList<>();
        for (int i = everyIndex; i < eligibleParcels.size(); i += everyIndex) {
            discounted.add(eligibleParcels.get(i));
        }

        return cheapestParcel(discounted);
    }

    private Parcel cheapestParcel(List<Parcel> discounted) {
        // If there are no discounted parcels, just return a dummy parcel
        // that isn't connected to any order to apply the discount
        if (discounted.isEmpty()) {
            return ParcelBuilder.aParcel().build();
        }

        Parcel cheapestParcel = discounted.get(0);

        for (Parcel p : discounted) {
            if (p.cost() < cheapestParcel.cost()) {
                cheapestParcel = p;
            }
        }
        return cheapestParcel;
    }

    public List<Parcel> removeDiscountedParcels(List<Parcel> parcels) {
        return parcels.stream().filter(p -> !p.isDiscounted()).collect(Collectors.toList());
    }


    /**
     * Applies the given discounts currently available
     */
    public void apply() {
        List<Parcel> parcels = order.getParcels();
        parcels = removeDiscountedParcels(parcels);

        Parcel sp = smallParcelMania(parcels);
        sp.applyDiscount();

        Parcel mp = mediumParcelMania(parcels);
        mp.applyDiscount();

        Parcel mip = mixedParcelMania(parcels);
        mip.applyDiscount();
    }
}
