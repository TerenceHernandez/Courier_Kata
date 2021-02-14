import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelTest {
    @Test
    public void smallParcelCostTest() {
        // A small parcel is one where all dimensions < 10cm
        List<Parcel> smallParcels = new ArrayList<>(
                Arrays.asList(
                        new Parcel(0, 0, 9),
                        new Parcel(0, 9, 0),
                        new Parcel(9, 0, 0),
                        new Parcel(9, 9, 9)
                )
        );

        for (Parcel smallParcel : smallParcels) {
            assertEquals(3, smallParcel.cost());
        }

    }
}
