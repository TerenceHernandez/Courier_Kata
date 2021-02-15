import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTestSuite {
    private Parcel parcel;
    private Order order;
    private Order speedyOrder;

    @BeforeEach
    public void initTest() {
        parcel = ParcelBuilder.aParcel().withLength(10).withWidth(10).withHeight(10).build();
        order = new Order(
                parcel,
                false
        );
        speedyOrder = new Order(
                parcel,
                true
        );
    }

    @Test
    public void orderPriceEqualToTotalPackage() {
        assertEquals(parcel.cost(), order.totalPrice());
    }

    @Test
    public void speedyOrderDoublesTotalPrice() {
        assertEquals(2 * order.totalPrice(), speedyOrder.totalPrice());
    }

    @Test
    public void speedyShippingListedAsSeparateOutputInOrder() {
        String speedyOrderOutput = speedyOrder.toString();
        String speedyShippingInfo = speedyOrder.shippingInfo();
        assertTrue(speedyOrderOutput.contains(speedyShippingInfo));
    }

    @Test
    public void speedyShippingShouldNotImpactIndividualItemPrice() {
        int oldParcelCost = parcel.cost();

        Order newSpeedyShipping = new Order(
                parcel,
                true
        );

        List<Parcel> orderParcels =  newSpeedyShipping.getParcels();
        int newParcelCost = orderParcels.get(0).cost();

        assertEquals(oldParcelCost, newParcelCost);
    }

    @Test
    public void speedyShippingAfterDiscountApplied() {
        Parcel sampleSmallParcel =  ParcelBuilder.aParcel().withHeight(9).build();

        List<Parcel> parcels = new ArrayList<>(
                Arrays.asList(
                        ParcelBuilder.aParcel().withHeight(9).build(),
                        ParcelBuilder.aParcel().withHeight(9).build(),
                        ParcelBuilder.aParcel().withHeight(9).build(),
                        ParcelBuilder.aParcel().withHeight(9).build(),
                        ParcelBuilder.aParcel().withHeight(9).build()
                )
        );

        Order order = new Order(parcels, true);
        DiscountApplier applier = new DiscountApplier(order);
        applier.apply();

        assertEquals( 2 * (4 - 1) * sampleSmallParcel.cost(), order.totalPrice());

    }
}
