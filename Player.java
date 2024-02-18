import java.util.ArrayList;

public class Player extends Entity {
    public final int MAX_ITEMS = 12;
    public int MAX_DEFENSE;
    public double MAX_DAMAGE;
    
    public boolean heavy;
    public int calorieCount;
    public boolean foodComa; 
    public int wallet;
    public ArrayList<Item> backpack;

    public Player() {
        super();
        this.calorieCount = 0;
        this.backpack = new ArrayList<Item>();
        this.wallet = 40;
        this.foodComa = false;
        this.MAX_DAMAGE = 0;
        this.MAX_DEFENSE = 8;
    }

    public Player(String name, int defense, double health, double damage) {
        super(name, defense, health, damage);
        this.calorieCount = 0;
        this.backpack = new ArrayList<Item>();
        this.wallet = 40;
        this.foodComa = false;
        this.MAX_DAMAGE = 0;
        this.MAX_DEFENSE = 8;
        System.out.println("Hello, " + name + "!");
    }

    public void addItem(Item item) {
        if (backpack.size() >= MAX_ITEMS) {
            System.out.println("You can't carry more items!");
        }

        else {
            backpack.add(item);
            System.out.println("You bought " + item + " successfully.");
        }
    }

    public void printBackpack() {
        for (int i = 0; i < backpack.size(); ++i) {
            System.out.print(i + ": " + backpack.get(i));
        }
    }

    public void useItem(Entity e, Item item) {
        checkCalories();
        int happyValue;

        switch (item.itemType) {
            case frenchFries:
                if (this.defense < MAX_DEFENSE) {
                    this.defense += 2;
                }
                if (this.damage < MAX_DAMAGE) {
                    this.damage += 3;
                }
        
                break;
            case bigMac:
                this.MAX_DEFENSE += 5;
                this.MAX_DAMAGE += 3;
                break;
            case vanillaCone:
                this.health += (int) (Math.random() * 4) + 5;
                break;
            case oreoMcFlurry:
                this.health += (int) (Math.random() * 6) + 20;
                if ((int)(Math.random() * 100) + 1 < 10){
                    giveStatus(StatusEffect.brainFreeze);
                }
                break;
            case largeSprite:
                giveStatus(StatusEffect.none);
                break;
            case pinkSlime:
                e.giveStatus(StatusEffect.foodPoisoning);
                break;
            case happyMeal:
                // TODO: apply random (status?) effect
                happyValue = (int) Math.random() * 10000;
                if (happyValue <= 1){
                    this.health = 999;
                }
                else if(happyValue > 1 && happyValue < 2000){
                    this.health += (int) (Math.random() * 16) + 2;
                }
                else if(happyValue >= 2000 && happyValue < 3000){
                    this.health -= (int) (Math.random() * 10) + 1;
                }
                else if(happyValue >= 3000 && happyValue < 4000){
                    giveStatus(StatusEffect.brainFreeze);
                }
                else if(happyValue >= 4000 && happyValue < 6000){
                    giveStatus(StatusEffect.foodPoisoning);
                }
                else if(happyValue >= 6000 && happyValue < 7000){
                    giveStatus(StatusEffect.highCholesterol);
                }
                else break;

                break;
        }

        this.calorieCount += item.calories;
        System.out.println("You have now consumed " + calorieCount + " calories.");
    }

    public void checkCalories() {
        if (calorieCount >= 2000) {
            foodComa = true;
        }
        else if (foodComa == true && calorieCount <= 1000) {
        foodComa = false;
        }
    }

    public boolean getFoodComa(){
        return foodComa;
    }

    @Override
    public void taunt(Entity e) {
        if (e.defense > 0) {
            this.calorieCount -= 100;
            e.defense -= 1;
            if (this.damage < MAX_DAMAGE) {
                this.damage += 2;
            }
            String insult = insults[(int) Math.random() * insults.length];
            System.out.println("You call your opponent " + insult + ". Enemy defense decreased.");
        } else {
            System.out.println("Enemy defense cannot be lowered further.");
        }
    }
    
    @Override
    public void defend(Entity e) {
        if (this.defense < MAX_DEFENSE) {
            this.calorieCount -= 100; 
            this.defense += 1;
            if (e.damage > 2) {
                e.damage -= 2;
            }
            System.out.println("You tape rolls of toilet paper to yourself. Defense increased.");
        } else {
            System.out.println("Your defense cannot go higher.");
        }
        main.clear();
    }

    @Override
    public void attack(Entity e) {
        int roll = (int) Math.random() * 6 + 1;
        double turnDmg = this.damage;
        this.calorieCount -= 150;

        switch (roll) {
            case 1:{
                System.out.println("You throw a jab, slightly grazing your opponent.");
                turnDmg -= 2;
                break;
            }
            case 2:{
                System.out.println("Your opponent braces as you swipe left on their tinder profile.");
                turnDmg -= 1;
                break;
            }
            case 3:
            case 4:{
                System.out.println("You punch your opponent, landing a blow to their face.");
                //turnDmg = this.damage;
                break;
            }
            case 5:{
                System.out.println("You manage to land an uppercut on your opponent.");
                turnDmg += 1;
                break;
            }
            case 6:{
                System.out.println("You swing a scooter at your opponent, shattering their shins.");
                turnDmg += 2;
                break;
            }
        }
        System.out.println("You deal " + turnDmg + " damage.");
        e.health -= turnDmg;
    }

    public void gameOver() {
        System.out.println("You died...");
        if (this.wallet >= 50) {
            System.out.println("Would you like to spend 50 coins to revive (yes/y) or give up (no/n)?");
            String input = main.sc.next();
            if (input == "yes" || input == "y") {
                this.wallet -= 50;
                return;
            }
            
        }
    }
}
