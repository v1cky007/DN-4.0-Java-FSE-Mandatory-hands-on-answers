import java.util.*;

public class SearchDemo {

    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId)
                return mid;
            else if (products[mid].productId < targetId)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Smartphone", "Electronics"),
            new Product(103, "Headphones", "Accessories"),
            new Product(104, "Backpack", "Travel"),
            new Product(105, "Desk Chair", "Furniture"),
            new Product(106, "Coffee Maker", "Appliances"),
            new Product(107, "Notebook", "Stationery"),
            new Product(108, "Pen Drive", "Electronics"),
            new Product(109, "Wireless Mouse", "Accessories"),
            new Product(110, "Shoes", "Footwear"),
            new Product(111, "Watch", "Accessories"),
            new Product(112, "Bookshelf", "Furniture"),
            new Product(113, "Sunglasses", "Fashion"),
            new Product(114, "T-shirt", "Clothing"),
            new Product(115, "Refrigerator", "Appliances"),
            new Product(116, "Gaming Console", "Electronics"),
            new Product(117, "Monitor", "Electronics"),
            new Product(118, "Water Bottle", "Travel"),
            new Product(119, "Wallet", "Fashion"),
            new Product(120, "LED Bulb", "Home Improvement")
        };

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        int targetId = 117;

        int linearIndex = linearSearch(products, targetId);
        System.out.println("Linear Search: Product found at index " + linearIndex);

        int binaryIndex = binarySearch(products, targetId);
        System.out.println("Binary Search: Product found at index " + binaryIndex);
    }
}
