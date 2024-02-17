public class Entity {

    private int defense;
    private int health;
    private int damage;
    private String statusEffect;
    
    //Tutorial boss
    final int GRIMSHAIKH_HP = 50;
    final int GRIMSHAIKH_DMG = 2;

    final int GRIMHP = 100;
    final int GRIMDMG = 8;

    final int HAMHP = 150;
    final int HAMDMG = 10;

    final int BIGHP = 200;
    final int BIGDMG = 12;

    final int MAYHP = 250;
    final int MAYDMG = 15;

    final int RONHP = 500;
    final int RONDMG = 25;

    public Entity() {
        this.defense = defense;
        this.health = health;
        this.damage = damage;
    }

    public void giveStatus(int n){
        switch (n) {
            //Paralysis
            case 1: {
                statusEffect = "Brain Freeze";
                break;
            }
            //Confuse
            case 2: {
                statusEffect = "High Choleesterol";
                break;
            }
            //Poison
            case 3: {
                statusEffect = "Food Poisoning";
                break;
            }
        }
    }

    public boolean checkStatus() {}

    public String getStatus() {
        return statusEffect;
    }

    public int getDef() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getAtk() {
        return damage;
    }

    public void addAtk(int inc) {
        damage += inc;
    }

    public void addDef(int inc) {
        defense += inc;
    }

    public void addHealth(int inc) {
        health += inc;
    }
    }