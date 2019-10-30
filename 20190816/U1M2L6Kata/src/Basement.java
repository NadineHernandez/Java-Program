public class Basement {
    private int length;
    private int width;
    private int sqFootage = length * width;
    private String flooring;
    private boolean areBats;

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

    public int getSqFootage() {
        return sqFootage;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public void removeBats() {
        this.areBats = false;
        System.out.println("That was the worst!");
    }
}
