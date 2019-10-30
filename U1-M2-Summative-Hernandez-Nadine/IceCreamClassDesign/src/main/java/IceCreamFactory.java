public class IceCreamFactory {
//class set up to produce invoice
    private String flavor;
    private int gallons;
    private double pricePerGallon;
    private double shippingCost;
    private double subtotal;
    //tax is predefined and cannot be changed. read only
    private double salesTax = 0.06d;
    private double total;

    //constructor for IceCream objects to be instantiated per transaction
    public IceCreamFactory(String flavor, int gallons, double pricePerGallon, double shippingCost){
        this.flavor = flavor;
        this.gallons = gallons;
        this.pricePerGallon = pricePerGallon;
        this.shippingCost = shippingCost;
    }

    //this method calculates the subtotal and prints out the math which results in our total
    public void calculateSubtotal(){
        this.subtotal = ((pricePerGallon * gallons) + shippingCost);

        System.out.println("IceCream Invoice Subtotal\n" +
                this.flavor + ": $" + pricePerGallon + " * " + gallons + " gallons\n" +
                "+ shipping cost: $" + shippingCost + "\n" +
                "______________________\n" +
                "Subtotal: " + this.subtotal);
    }

    //this method takes the subtotal and applies sales tax. It returns the complete total
    public double calculateTotal(){
        this.total = this.subtotal * (1 + this.salesTax);
        //returns total as double instead of printing so that this variable can be used in future operations
        return this.total;
        //there are no getters or setters for total because it must be calculated and returns its double
    }

    //getters and setters for private properties
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getGallons() {
        return gallons;
    }

    public void setGallons(int gallons) {
        this.gallons = gallons;
    }

    public double getPricePerGallon() {
        return pricePerGallon;
    }

    public void setPricePerGallon(double pricePerGallon) {
        this.pricePerGallon = pricePerGallon;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    //subtotal has no set and must be calculated
    public double getSubtotal() {
        return subtotal;
    }

    //sales tax has no set and is read only
    public double getSalesTax() {
        return salesTax;
    }

    //uncomment to test
/*    public static void main(String[] args) {
        IceCreamFactory fact = new IceCreamFactory("Cholocalte", 20, 5.50d, 30);

        fact.calculateSubtotal();
        System.out.println(fact.calculateTotal());
    }*/
}
