import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountApplierTestSuite {

    private Order order = new Order();
    private DiscountApplier discountAppplier = new DiscountApplier(order);

    private void discountedParcelPriceStaysTheSame(Parcel dp) {
        assertNotEquals(0, dp.cost());
    }

    @Test
    public void smallParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(9).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        Parcel discountedParcel = parcels.get(DiscountApplier.smallParcelManiaIndex);

        assertTrue(discountedParcel.isDiscounted());
        discountedParcelPriceStaysTheSame(discountedParcel);
    }

    @Test
    public void mediumParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(49).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        Parcel discountedParcel = parcels.get(DiscountApplier.mediumParcelManiaIndex);

        assertTrue(discountedParcel.isDiscounted());
        discountedParcelPriceStaysTheSame(discountedParcel);
    }

    @Test
    public void mixedParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(9).withWeight(i).build());
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(49).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        Parcel discountedParcel = parcels.get(DiscountApplier.mixedParcelManiaIndex);

        assertTrue(discountedParcel.isDiscounted());
        discountedParcelPriceStaysTheSame(discountedParcel);
    }

    // Generally, I would want this to have a mock to show that apply()
    // i.e. discountAppplier.apply() calls removeDiscountedParcels() as a Mock test
    @Test
    public void discountNotAppliedTwiceToParcel() {

        List<Parcel> parcelList = new ArrayList<>();

        // Generate random parcels with discounts
        for (int i = 0; i < 1000; i++) {
            Parcel randomParcel = ParcelBuilder.aParcel().build();

            if (Math.random() < 0.5) {
                randomParcel.applyDiscount();
            }
            parcelList.add(randomParcel);
        }

        List<Parcel> parcels = discountAppplier.removeDiscountedParcels(parcelList);

        for (Parcel p : parcels) {
            assertFalse(p.isDiscounted());
        }

    }

}
