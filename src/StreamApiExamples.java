
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + '\'' + ", price=" + price + '}';
    }
}

public class StreamApiExamples {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60);

        System.out.println("Original List: " + numbers);

        List<Integer> filteredNumbers = numbers.stream()
                                               .dropWhile(n -> n < 30)
                                               .collect(Collectors.toList());

        System.out.println("After dropWhile (n < 30): " + filteredNumbers);

        List<Integer> skippedNumbers = numbers.stream()
                                              .skip(2)
                                              .collect(Collectors.toList());

        System.out.println("After skip(2): " + skippedNumbers);

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1200.99));
        products.add(new Product(2, "Phone", 799.49));
        products.add(new Product(3, "Tablet", 450.0));
        products.add(new Product(4, "Monitor", 300.5));
        products.add(new Product(5, "Keyboard", 99.99));

        System.out.println("\nOriginal Product List:");
        products.forEach(System.out::println);

        List<Product> expensiveProducts = products.stream()
                                                  .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                                                  .dropWhile(p -> p.getPrice() <= 500)
                                                  .collect(Collectors.toList());

        System.out.println("\nProducts with price > 500:");
        expensiveProducts.forEach(System.out::println);

        List<Product> skippedProducts = products.stream()
                                                .skip(2)
                                                .collect(Collectors.toList());

        System.out.println("\nProduct List after skip(2):");
        skippedProducts.forEach(System.out::println);

        List<Integer> evenNumbers = IntStream.range(1, 20)
                                             .filter(n -> n % 2 == 0)
                                             .boxed()
                                             .collect(Collectors.toList());

        System.out.println("\nEven Numbers between 1 and 20:");
        System.out.println(evenNumbers);

        List<String> productNames = products.stream()
                                            .map(Product::getName)
                                            .collect(Collectors.toList());

        System.out.println("\nProduct Names:");
        productNames.forEach(System.out::println);
    }
}

