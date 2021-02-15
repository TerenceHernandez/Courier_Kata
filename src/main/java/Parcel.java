abstract class Parcel {

    private int weight;
    private int baseCost;
    private int overWeightPrice;
    private int weightLimit;
    private boolean discounted;

    public Parcel(int weight, int baseCost, int overWeightPrice, int weightLimit) {
        this.weight = weight;
        this.baseCost = baseCost;
        this.overWeightPrice = overWeightPrice;
        this.weightLimit = weightLimit;
        this.discounted = false;
    }

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