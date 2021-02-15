abstract class Parcel {

    private final int length;
    private final int width;
    private final int height;
    private int weight;
    private int baseCost;
    private int overWeightPrice;
    private int weightLimit;
    private boolean discounted;

    public Parcel(int length, int width, int height, int weight, int baseCost, int overWeightPrice, int weightLimit) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        this.baseCost = baseCost;
        this.overWeightPrice = overWeightPrice;
        this.weightLimit = weightLimit;
        this.discounted = false;
    }

    public int cost() {
        if (discounted) {
            return 0;
        }

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