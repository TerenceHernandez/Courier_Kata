import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class OrderTestSuite {

    @Test
    public void orderPriceEqualToTotalPackage() {

        Parcel parcel = ParcelBuilder.aParcel().withLength(10).withWidth(10).withHeight(10).build();
        Order order = new Order(
                parcel,
                false
        );

        assertEquals(parcel.cost(), order.totalPrice());
    }

    @Test
    public void speedyOrderDoublesTotalPrice() {

        Parcel parcel = ParcelBuilder.aParcel().withLength(10).withWidth(10).withHeight(10).build();
        Order order = new Order(
                parcel,
                false);
        Order speedyOrder = new Order(
                parcel,
                true);

        assertEquals(2 * order.totalPrice(), speedyOrder.totalPrice());
    }
}
