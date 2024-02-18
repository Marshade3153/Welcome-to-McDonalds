public class Fight {
    private Entity[] bosses = {new Entity("Grimace Shake", 4, 50, 2), new Entity("Uncle o' Grimace", 4, 100, 8),
            new Entity("Ice Cream Machine", 4, 130, 9), new Entity("Hamburgler", 4, 150, 10), new Entity("Officer Big Mac", 4, 200, 12),
            new Entity("Mayor McCheese", 4, 250, 12), new Entity("Ronald McDonald", 4, 500, 25)};

    private static int bossIndex;
    public static int difficulty;

    public Fight(int diff) {
        bossIndex = 0;
        setDifficulty(diff);
    }

    private void setDifficulty(int diff) {
        double difficulty_multiplier = 0;

        switch (diff) {
            case 1:
                difficulty_multiplier = 0.75f;
                break;
            case 2:
                difficulty_multiplier = 1.00f;
                break;
            case 3:
                difficulty_multiplier = 1.50f;
                break;
            default: {
                System.out.println("Invalid difficulty");
                difficulty_multiplier = 15.00f;
                break;
            }
        }
        
        for (int i = 0; i < bosses.length; i++) {
            bosses[i].damage *= difficulty_multiplier;
            bosses[i].health *= difficulty_multiplier;
        }
    }
    
    private void takeTurn(Player p1, Entity boss, int turnCounter, int numTaunts) {
        p1.checkStatusEffect();
        boss.checkStatusEffect();
        
        switch(p1.statusEffect){
            case brainFreeze:{
                int chance = (int) Math.random() * 100;
                if (chance < 10){
                    return;
                }
                break;
            }
            case foodPoisoning:{
                if(p1.health > 2)
                    p1.health -= 2;
                break;
            }
            case none:{
                break;
            }
            default: {
                System.out.println("Fatal Error. Exiting...");
                return;
            }
        }

        switch(boss.statusEffect){
            case brainFreeze:{
                int chance = (int) Math.random() * 100;
                if (chance < 10){
                    return;
                }
                break;
            }
            case foodPoisoning:{
                if(boss.health > 20)
                    boss.health -= 5;
                break;
            }
            case none:{
                break;
            }
            default: {
                System.out.println("Fatal Error. Exiting...");
                return;
            }
        }
        
        if (turnCounter % 2 == 1){
            // boss's turn
            int choice = (int) Math.random() * 100;
            int attackRange = bossIndex * 100 / bosses.length;
            
            if (numTaunts > 0) {
                // Taunt
                boss.taunt(p1);
                numTaunts--;
            } else if (choice <= attackRange) {
                boss.attack(p1);
            } else {
                boss.defend(p1);
            }
        } 
        else {
            System.out.println(p1.name + ": " + p1.health);
            System.out.println();
            System.out.println(boss.name + ": " + boss.health);
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("\t(1) Attack\n\t(2) Defend\n\t(3) Taunt\n\t(4) Item");
            
            // player's turn
            int choice = main.sc.nextInt();
            while (choice > 5 || (p1.backpack.size() == 0)) {
                choice = main.sc.nextInt();
            } 
            main.clear();
            //Attack
            if (choice == 1) {
                p1.attack(boss);
            } 
            //Defend
            else if (choice == 2) {
                p1.defend(boss);
            }
            //Taunt
            else if (choice == 3) {
                p1.taunt(boss);
            }
            //Item
            else if (choice == 4 && p1.backpack.size() > 0) {
                System.out.println("What item would you like to use?");
                p1.printBackpack();
                int itemChoice = main.sc.nextInt();
                while (itemChoice > p1.backpack.size()) {
                    System.out.println("Input a valid item # (0 - " + (p1.backpack.size() - 1) + ")");
                    itemChoice = main.sc.nextInt();
                }
                main.clear();

                Item item = p1.backpack.get(itemChoice);
                if (p1.getFoodComa() == false) {
                    p1.useItem(boss, item);
                }
                else {
                    System.out.println("Too fat");
                }
            }
            else if (choice == 5){
                System.out.println("Thank you for playing!");
                return;
            } 
            else {
                System.out.println("Invalid input loser");
                main.clear();
            }
            
        }
    }

    public void fightNextBoss(Player player) {
        Entity boss = bosses[bossIndex];

        int turnCounter = 0;
        int numTaunts = Math.min(4, bosses.length - bossIndex);

        do {
            if (player.health > 0) {
                takeTurn(player, boss, turnCounter, numTaunts);
            } else {
                //player.gameOver();
                return;
            }
            
            turnCounter++;
        } while (boss.health < 0);

        player.wallet += ((int) Math.random() * 10 - 5) + bosses[bossIndex].health / 2;
        bossIndex++;
    }

    public boolean moreBosses() {
        return bossIndex < bosses.length;
    }
}
