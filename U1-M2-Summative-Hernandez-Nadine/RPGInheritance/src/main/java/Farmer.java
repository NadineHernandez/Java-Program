public class Farmer extends Character{
    //initial values for farmer set
    private int strength = 75;
    private int health = 100;
    private int stamina = 75;
    private int speed = 10;
    private int attackPower = 1;

    //farmer has plow and harvest methods in addition to access to Character methods
    public void plow(){
        //prints this.name plows field
        System.out.println(this.getName() + " plows the field.");
    }

    public void harvest(){
        //prints this.name harvests the crops
        System.out.println(this.getName() + " harvests the crops.");
    }
}
