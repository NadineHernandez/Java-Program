public class Warrior extends Character{
    private int strength = 75;
    private int health = 100;
    private int stamina = 100;
    private int speed = 50;
    private int attackPower = 10;
    //warrior has and integer variable shieldStrength in addition to Character properties
    private int shieldStrength = 100;

    //Warrior has decreaseShieldStrength method in addition to access to Character methods
    public void decreaseShieldStrength(){
        //decrements shieldStrength by 1
        this.shieldStrength --;
    }

    //getters and setters for additional variable
    public int getShieldStrength() {
        return shieldStrength;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }
}
