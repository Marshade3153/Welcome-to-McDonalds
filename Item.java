public class Item {
    public static final Item[] allItems = {
        new Item(320, 15, ItemType.frenchFries, "\tIncrease ATK by 3 and DEF by 2. Not enough salt though."),
        new Item(600, 25, ItemType.bigMac, "\tPermanently increases max ATK by 3 and max DEF by 5. Just remove the weird middle bun."),
        new Item(200, 15, ItemType.vanillaCone, "\tHeals you a small amount. If only the servings were bigger."),
        new Item(650, 30, ItemType.oreoMcFlurry, "\tHeals you a lot, but has a small chance of giving you brain freeze. Stay frosty!"),
        new Item(380, 25, ItemType.largeSprite, "\tRemoves all negative status effects from self. Very refreshing"),
        new Item(0, 15, ItemType.pinkSlime, "\t"),
        new Item(300, 20, ItemType.happyMeal, "\t")
    };

    public int calories;
    public int cost;
    public ItemType itemType;
    public String description;

    private Item(int calories, int cost, ItemType itemType, String description) {
        this.calories = calories;
        this.cost = cost;
        this.itemType = itemType;
        this.description = description;
    }

    public String toString() {
        return this.itemType.toString() + "\n" + this.description;
    }
}
