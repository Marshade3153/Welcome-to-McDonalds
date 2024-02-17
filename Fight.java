public class Fight{
    private Entity boss = new Entity();
    private Player plyr1 = new Player();

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

    private static int bossIndex;
    public static int difficulty;

    public Fight(int index, int diff){
        bossIndex = index;
        difficulty = diff;
    }

    private void setDifficulty(){
        switch(bossIndex){
            //Grimace Shake
            case 1:{
                boss.setName("Grimace Shake")
                if (difficulty == 1){
                    boss.setHealth(GRIMSHAIKH_HP * .75);
                    boss.setAtk(GRIMSHAIKH_DMG * .75);
                }
                else if (difficulty == 2){
                    boss.setHealth(GRIMSHAIKH_HP);
                    boss.setAtk(GRIMSHAIKH_DMG);
                }
                else if (difficulty == 1){
                    boss.setHealth(GRIMSHAIKH_HP * 1.5);
                    boss.setAtk(GRIMSHAIKH_DMG * 1.5);
                }
                break;
            }
            //Grimace
            case 2:{
                boss.setName("Uncle O' Grimace")
                if (difficulty == 1){
                    boss.setHealth(GRIMHP * .75);
                    boss.setAtk(GRIMDMG * .75);
                }
                else if (difficulty == 2){
                    boss.setHealth(GRIMHP);
                    boss.setAtk(GRIMDMG);
                }
                else if (difficulty == 1){
                    boss.setHealth(GRIMHP * 1.5);
                    boss.setAtk(GRIMDMG * 1.5);
                }
                break;
            }
            //Hambn
            case 3:{
                boss.setName("Uncle O' Grimace")
                if (difficulty == 1){
                    boss.setHealth(GRIMHP * .75);
                    boss.setAtk(GRIMDMG * .75);
                }
                else if (difficulty == 2){
                    boss.setHealth(GRIMHP);
                    boss.setAtk(GRIMDMG);
                }
                else if (difficulty == 1){
                    boss.setHealth(GRIMHP * 1.5);
                    boss.setAtk(GRIMDMG * 1.5);
                }
                break;
            }   
        }
    }

    
}