import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelCostTestSuite {

    // Driver code for a parcel cost test
    private void parcelCostTest(Integer maxDimension, Integer minDimension, int cost) {
        int dimension = maxDimension != null ? maxDimension : minDimension;

        List<Parcel> smallParcels = new ArrayList<>(
                Arrays.asList(
                        ParcelBuilder.aParcel().withLength(0).withWidth(0).withHeight(dimension).build(),
                        ParcelBuilder.aParcel().withLength(0).withWidth(dimension).withHeight(0).build(),
                        ParcelBuilder.aParcel().withLength(dimension).withWidth(0).withHeight(0).build(),
                        ParcelBuilder.aParcel().withLength(dimension).withWidth(dimension).withHeight(dimension).build()
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


