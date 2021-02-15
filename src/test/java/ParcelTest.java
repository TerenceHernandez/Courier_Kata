import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelTest {

    // Driver code for a parcel cost test
    private void parcelCostTest(Integer maxDimension, Integer minDimension, int cost) {
        int dimension = maxDimension != null ? maxDimension : minDimension;

        List<Parcel> smallParcels = new ArrayList<>(
                Arrays.asList(
                        new Parcel(0, 0, dimension),
                        new Parcel(0, dimension, 0),
                        new Parcel(dimension, 0, 0),
                        new Parcel(dimension, dimension, dimension)
                )
        );

        for (Parcel smallParcel : smallParcels) {
            assertEquals(cost, smallParcel.cost());
        }
    }
    @Test
    public void smallParcelCostTest() {
        // A small parcel is one where all dimensions < 10cm
        parcelCostTest(9, null, 3);
    }

    @Test
    public void mediumParcelCostTest() {
        // A medium parcel is one where all dimensions < 50cm
        parcelCostTest(49, null, 8);
    }

    @Test
    public void largeParcelCostTest() {
        // A small parcel is one where all dimensions < 100cm
        parcelCostTest(99, null, 15);
    }

    @Test
    public void extraLargeParcelCostTest() {
        // A small parcel is one where any dimensions >= 100cm
        parcelCostTest(null, 100, 25);
    }
}


