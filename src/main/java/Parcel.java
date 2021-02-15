abstract class Parcel {

    private int weight;
    private int baseCost;
    private int overWeightPrice;
    private int weightLimit;
    private boolean discounted;

    /**
     * Parcels are the representation of a customer's parcel
     * @param weight
     * @param baseCost
     * @param overWeightPrice
     * @param weightLimit
     */
    public Parcel(int weight, int baseCost, int overWeightPrice, int weightLimit) {
        this.weight = weight;
        this.baseCost = baseCost;
        this.overWeightPrice = overWeightPrice;
        this.weightLimit = weightLimit;
        this.discounted = false;
    }

    /**
     *
     * @return - The cost of a parcel, before any discount is applied
     */
    public int cost() {
        if (getWeight() > weightLimit) {
            return baseCost + (getWeight() - weightLimit) * overWeightPrice;
        }

        return baseCost;
    }

    public boolean isDiscounted() {
        return discounted;
    }

    public void applyDiscount() {
        discounted = true;
    }

    public int getWeight() {
        return weight;
    }
}