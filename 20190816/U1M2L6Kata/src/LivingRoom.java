public class LivingRoom {
    private int length;
    private int width;
    private int sqFootage = length * width;
    private String flooring;
    private boolean tvIsOn;

    public int getSqFootage() {
        return sqFootage;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public void watchTV(boolean tvIsOn) {
        if (tvIsOn){
            System.out.println("I love this show.");
        } else {
            System.out.println("Where's the remote? Oh.");
            this.tvIsOn = true;
        }
    }
}
