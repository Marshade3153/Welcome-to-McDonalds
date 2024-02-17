public class Player extends Entity{
    private String name;
    private boolean heavy;
    private boolean heal;
    

    public Player() {
        super();
        this.name = "";
    }

    public Player(String name) {
        super();
        this.name = name;
        System.out.println("Hello, " + name + "!");
    }

    public void turn(){
        double roll = Math.random() % 6 + 1;   
    }
}