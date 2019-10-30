public class Kitchen {
    private int length;
    private int width;
    private int sqFootage = length * width;
    private String flooring;
private boolean ovenIsOn;

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

    public void cook(boolean ovenIsOn){
        if (ovenIsOn == false){
            this.ovenIsOn = true;
        }
        System.out.println("Let's get cooking!");
    }
}
