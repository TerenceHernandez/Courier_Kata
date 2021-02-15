import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountApplier {

    public static int smallParcelManiaIndex = 3;
    public static int mediumParcelManiaIndex = 2;
    public static int mixedParcelManiaIndex = 4;

    private Order order;

    public DiscountApplier(Order order) {
        this.order = order;
    }

    private Parcel smallParcelMania() {
        List<Parcel> parcels = order.getParcels();

        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof SmallParcel).collect(Collectors.toList()); // Need to add check for isDiscounted

        return parcelMania(smallParcelManiaIndex, smallParcels);
    }

    private Parcel mediumParcelMania() {
        List<Parcel> parcels = order.getParcels();

        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof MediumParcel).collect(Collectors.toList()); // Need to add check for isDiscounted

        return parcelMania(mediumParcelManiaIndex, smallParcels);
    }

    private Parcel mixedParcelMania() {
        List<Parcel> parcels = order.getParcels();

        List<Parcel> smallParcels =
                parcels.stream().filter(p -> p instanceof Parcel).collect(Collectors.toList()); // Need to add check for isDiscounted

        return parcelMania(mixedParcelManiaIndex, smallParcels);
    }

    private Parcel parcelMania(int everyIndex, List<Parcel> eligibleParcels) {

        List<Parcel> discounted = new ArrayList<>();
        for (int i = everyIndex; i < eligibleParcels.size(); i += everyIndex) {
            discounted.add(eligibleParcels.get(i));
        }
        System.out.println(discounted);

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
        System.out.println(cheapestParcel);
        return cheapestParcel;
    }

    public void apply() {
        Parcel sp = smallParcelMania();
        sp.applyDiscount();

        Parcel mp = mediumParcelMania();
        mp.applyDiscount();

        Parcel mip = mixedParcelMania();
        mip.applyDiscount();
    }
}
