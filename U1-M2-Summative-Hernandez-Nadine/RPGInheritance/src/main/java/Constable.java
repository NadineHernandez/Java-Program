public class Constable extends Character{
    //inital values for constable assigned
    private int strength = 60;
    private int health = 100;
    private int stamina = 60;
    private int speed = 20;
    private int attackPower = 5;
    //constable has a boolean jurisdiction in addition to Character properties
    private boolean jurisdiction;

    //in addition to the Character methods, Constable objects have access to arrest method
    public void arrest(){
        //if the arrest is attempted in the constables jurisdiction(true) them arrest is made else print unable message
        if (jurisdiction) {
            System.out.println(this.getName() + " makes an arrest.");
        } else {
            System.out.println(this.getName() + " cannot make an arrest outside of their jurisdiction.");
        }
    }

    //getters and setters for additional variable
    public boolean isJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(boolean jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
