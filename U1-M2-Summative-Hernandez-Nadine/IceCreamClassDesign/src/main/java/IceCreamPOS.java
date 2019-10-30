public class IceCreamPOS {
    //for creating retail sale transaction in pos
    private double salesTax = 0.06d;
    //sales tax is predefined and read only
    private double scoopPrice;
    private int scoops;
    private String flavor;
    private String topping;
    private double toppingPrice;
    private String coneType;
    private double conePrice;
    private double subtotal;
    private double total;

    //constructor takes in variables necessary to perform pos calculations in object
    public IceCreamPOS(double scoopPrice, int scoops, String flavor, String topping, double toppingPrice,
                       String coneType, double conePrice){

        this.scoopPrice = scoopPrice;
        this.scoops = scoops;
        this.flavor = flavor;
        this.topping = topping;
        this.toppingPrice = toppingPrice;
        this.coneType = coneType;
        this.conePrice = conePrice;
    }

    //method calculates subtotal and prints result as well as all contributing math
    public void calculateSubtotal(){
        this.subtotal = ((scoops*scoopPrice) + toppingPrice + conePrice);

        System.out.println("IceCream Subtotal\n" +
                this.flavor + ": $" + this.scoopPrice + " * " + this.scoops + " scoops\n" +
                "+ " + this.topping + ": $" + this.toppingPrice + "\n" +
                "+ " + this.coneType + ": $" + this.conePrice + "\n" +
                "______________________\n" +
                "Subtotal: " + this.subtotal);
    }

    //method calculates total which is the subtotal with the tax applied
    public double calculateTotal(){
        this.total = this.subtotal * (1 + this.salesTax);
        //returns a double instead of printing so that variable can be used in future operations
        return this.total;
        //there are no getters and setters for total because it must be calculated in this method
    }

    //getters and setters for private variables
    public int getScoops() {
        return scoops;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

    public double getSalesTax() {
        return salesTax;
    }


    public double getScoopPrice() {
        return scoopPrice;
    }

    public void setScoopPrice(double scoopPrice) {
        this.scoopPrice = scoopPrice;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public String getConeType() {
        return coneType;
    }

    public void setConeType(String coneType) {
        this.coneType = coneType;
    }

    public double getConePrice() {
        return conePrice;
    }

    public void setConePrice(double conePrice) {
        this.conePrice = conePrice;
    }

    //there is no subtotal setter because it must be calculated
    public double getSubtotal() {
        return subtotal;
    }

    //can be uncommented to perform tests
/*    public static void main(String[] args) {
        IceCreamPOS sale = new IceCreamPOS(2.25d, 2, "Vanilla", "Sprinkles",
                0.25d, "Cake Cone", 0.25d);

        sale.calculateSubtotal();
        System.out.println(sale.calculateTotal());
    }*/
}
