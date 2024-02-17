public class Entity {

    private int defense = 4;
    private double health;
    private double damage;
    private String statusEffect;

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

    public String getStatus() {
        return statusEffect;
    }

    


    public int getDef() {
        return defense;
    }

    public double getHealth() {
        return health;
    }

    public double getAtk() {
        return damage;
    }

    public void setAtk(double inc) {
        damage = inc;
    }

    public void setName(String s) {
        defense = s;
    }

    public void setHealth(double inc) {
        health = inc;
    }
}