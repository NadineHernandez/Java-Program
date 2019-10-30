public class Character {
    //these properties will be common to all child classes which extend this class
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    //these methods will be common to all child classes which extend this class
    public void run(){
        //prints that the character will move some number of spaces corresponding to speed
        System.out.println("Move " + this.speed + " spaces.");
        //calls the decrease stamina method to run after
        this.decreaseStamina();
    }

    public void attack(){
        //prints that the character inflicts a number of damage corresponding to attackPower
        System.out.println("Inflict " + this.attackPower + " damage.");
    }

    public void heal(){
        //increments health value by 1
        this.health ++;
        //calls increaseStamina method to run after
        this.increaseStamina();
    }

    public void decreaseHealth(){
        //decriments health value by 1
        this.health --;
    }

    public void increaseStamina(){
        //increments stamina value by 1
        this.stamina ++;
    }

    public void decreaseStamina(){
        //decriments stamina value by 1
        this.stamina --;
    }

    //getters and setters for private variables

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
}
