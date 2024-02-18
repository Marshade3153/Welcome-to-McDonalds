public class Shop {
    public final String[] servers = {"Sam", "Obie", "Cody", "Moe", "Mateen",
        "Ali Ben Ali", "George Weinschenk", "Harvey Stenger", "Mike Lewis", "Barack Obama", "McDonald Trump", "Patrick Madden"};
    public Shop() {
    }

    public void shop(Player player) {
        String server = servers[(int) Math.random() * servers.length];
        System.out.println("SHOP");
        System.out.println("Welcome to McDonald's. This is " + server + ", I'll be taking your order");
        System.out.println("You have " + player.wallet + " coins in your wallet");

        System.out.println("Here's our menu:");
        int i;
        for (i = 0; i < Item.allItems.length; ++i) {
            System.out.println("(" + (i + 1) + ") " + Item.allItems[i]);
        }
        System.out.println("(" + i + ") Exit the shop");

        int choice = main.sc.nextInt() - 1;
        while (choice > 8 || choice < 0) {
            System.out.println("Please input a valid number");
            choice = main.sc.nextInt();
        }

        if (choice == 8) {
            System.out.println("Thanks for shopping at McDonalds");
        }

        Item item = Item.allItems[choice];
        if (player.wallet >= item.cost) {
            player.addItem(item);
            player.wallet -= item.cost;
        }
    }
}
