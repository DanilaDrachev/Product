public class Smartphone extends Product {
    public String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }
}
