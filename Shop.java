public class Shop {
    public final String[] servers = {"Sam", "Obie", "Cody", "Moe", "Mateen",
        "Ali Ben Ali", "George Weinschenk", "Harvey Stenger", "Mike Lewis", "Barack Obama", "McDonald Trump"};
    public Shop() {
    }

    public void shop(Player player) {
        String server = servers[(int) Math.random() * servers.length];
        System.out.println("SHOP");
        System.out.println("Welcome to McDonald's. This is " + server + ", I'll be taking your order");
        System.out.println("You have " + player.wallet + " coins in your wallet");

        System.out.println("Here's our menu:");
        for (int i = 0; i < Item.allItems.length; ++i) {
            System.out.println("(" + i + ") " + Item.allItems[i]);
        }

        switch (main.sc.nextInt()) {
            case
        }
    }
}
