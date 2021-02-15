import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void speedyShippingShouldNotImpactIndividualItemPrict() {
        int oldParcelCost = parcel.cost();

        Order newSpeedyShipping = new Order(
                parcel,
                true
        );

        int newParcelCost = newSpeedyShipping.getParcel().cost();

        assertEquals(oldParcelCost, newParcelCost);
    }
}
