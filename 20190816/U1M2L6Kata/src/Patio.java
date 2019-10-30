public class Patio {
    private int length;
    private int width;
    private int sqFootage = length * width;
    private String flooring;
    private boolean tikiTorches;

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

    public void toggleTikiTorches(boolean tikiTorches) {
        if (tikiTorches) {
            this.tikiTorches = false;
        } else {
            this.tikiTorches = true;
        }
    }
}
