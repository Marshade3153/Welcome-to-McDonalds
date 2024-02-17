public class Player extends Entity{
    private String name;

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
        
    }
}