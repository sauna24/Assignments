
public class MainProgram {

    public static void main(String[] args) {
        Product tapeMeasure = new Product("Tape measure");
        Product plaster = new Product("plaster", "home imporvement section");
        Product tyre = new Product("Tyre", 5);
        
        System.out.println(tapeMeasure);
        System.out.println(plaster);
        System.out.println(tyre);
    }
}
