import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountApplierTestSuite {

    private Order order = new Order();
    private DiscountApplier discountAppplier = new DiscountApplier(order);

    @Test
    public void smallParcelManiaTest() {
        int freeOrderIndex = 3;

        for (int i = 1; i <= 5; i++) {
            order.add(ParcelBuilder.aParcel().withLength(1).withWidth(1).withHeight(9).withWeight(i).build());
        }

        discountAppplier.apply();

        List<Parcel> parcels = order.getParcels();
        assertEquals(0, parcels.get(freeOrderIndex).cost());
    }

    @Test
    public void mediumParcelManiaTest() {

    }

    @Test
    public void mixedParcelManiaTest() {

    }

}
