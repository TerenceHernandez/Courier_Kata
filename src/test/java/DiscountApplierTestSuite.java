import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountApplierTestSuite {

    private Order order = new Order();
    private DiscountApplier discountAppplier = new DiscountApplier(order);

    @Test
    public void smallParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(9).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        assertEquals(0, parcels.get(DiscountApplier.smallParcelManiaIndex).cost());
    }

    @Test
    public void mediumParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(49).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        assertEquals(0, parcels.get(DiscountApplier.mediumParcelManiaIndex).cost());
    }

    @Test
    public void mixedParcelManiaTest() {
        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(9).withWeight(i).build());
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(49).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        assertEquals(0, parcels.get(DiscountApplier.mixedParcelManiaIndex).cost());
    }

}
