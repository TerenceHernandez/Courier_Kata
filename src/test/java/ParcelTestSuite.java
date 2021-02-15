import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelTestSuite {

    // Driver code for a parcel cost test
    private void parcelCostTest(Integer maxDimension, Integer minDimension,int weight, int cost) {
        int dimension = maxDimension != null ? maxDimension : minDimension;

        List<Parcel> smallParcels = new ArrayList<>(
                Arrays.asList(
                        ParcelBuilder.aParcel().withLength(0).withWidth(0).withHeight(dimension)
                                .withWeight(weight).build(),
                        ParcelBuilder.aParcel().withLength(0).withWidth(dimension).withHeight(0)
                                .withWeight(weight).build(),
                        ParcelBuilder.aParcel().withLength(dimension).withWidth(0).withHeight(0)
                                .withWeight(weight).build(),
                        ParcelBuilder.aParcel().withLength(dimension).withWidth(dimension).withHeight(dimension)
                                .withWeight(weight).build()
                )
        );

        for (Parcel smallParcel : smallParcels) {
            assertEquals(cost, smallParcel.cost());
        }
    }
    @Test
    public void smallParcelCostTest() {
        // A small parcel is one where all dimensions < 10cm
        parcelCostTest(9, null, 0, SmallParcel.baseCost);
    }

    @Test
    public void mediumParcelCostTest() {
        // A medium parcel is one where all dimensions < 50cm
        parcelCostTest(49, null, 0, MediumParcel.baseCost);
    }

    @Test
    public void largeParcelCostTest() {
        // A small parcel is one where all dimensions < 100cm
        parcelCostTest(99, null, 0, LargeParcel.baseCost);
    }

    @Test
    public void extraLargeParcelCostTest() {
        // A small parcel is one where any dimensions >= 100cm
        parcelCostTest(null, 100, 0, ExtraLargeParcel.baseCost);
    }

    @Test
    public void smallParcelCostWithWeightTest() {
        int weight = 2;
        int overWeight = weight - SmallParcel.weightLimit;

        parcelCostTest(9, null, weight,
                SmallParcel.baseCost + overWeight * Parcel.overWeightPrice);
    }

    @Test
    public void mediumParcelCostWithWeightTest() {
        int weight = 4;
        int overWeight = weight - MediumParcel.weightLimit;
        parcelCostTest(49, null, weight,
                MediumParcel.baseCost + overWeight * Parcel.overWeightPrice);
    }

    @Test
    public void largeParcelCostWithWeightTest() {
        int weight = 7;
        int overWeight = weight - LargeParcel.weightLimit;
        parcelCostTest(99, null, weight,
                LargeParcel.baseCost + overWeight * Parcel.overWeightPrice);
    }

    @Test
    public void extraLargeParcelCostWithWeightTest() {
        int weight = 11;
        int overWeight = weight - ExtraLargeParcel.weightLimit;
        parcelCostTest(null, 100, weight,
                ExtraLargeParcel.baseCost + overWeight * Parcel.overWeightPrice);
    }
}


