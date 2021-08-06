package grokkingalgorithms;

import java.util.HashMap;

public class PriceOfGroceries {
    
    public static void main(String[] args) {
        HashMap<String, Double> book = new HashMap<>();
        
        book.put("apple", 0.67);
        book.put("milk", 1.49);
        book.put("avocado", 1.49);
        
        System.out.println(book);
        System.out.println(book.get("avocado"));
    }
}
