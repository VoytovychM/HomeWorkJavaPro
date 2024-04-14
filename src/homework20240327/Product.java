package homework20240327;

import java.util.PriorityQueue;

public class Product implements Comparable<Product> {
        String name;
        Integer expiryDate;

        public Product(String name, Integer expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        @Override
        public int compareTo(Product o) {
            return o.expiryDate.compareTo(this.expiryDate);
        }
    }
    class Store {
    PriorityQueue<Product> warehouse1;
    PriorityQueue<Product> warehouse2;

    public Store() {
        warehouse1 = new PriorityQueue<>();
        warehouse2 = new PriorityQueue<>();
    }
        public void addProduct(Product product, int warehouseNumber) {
            if (warehouseNumber == 1) {
                warehouse1.offer(product);
            } else if (warehouseNumber == 2) {
                warehouse2.offer(product);
            } else {
                System.out.println("Invalid warehouse number.");
            }
        }

        public Product getProduct() {
            if (!warehouse1.isEmpty() || !warehouse2.isEmpty()) {
                if (warehouse1.isEmpty()) {
                    return warehouse2.poll();
                } else if (warehouse2.isEmpty()) {
                    return warehouse1.poll();
                } else {
                    Product pwh1 =  warehouse1.peek();
                    Product pwh2 =  warehouse2.peek();
                    return pwh1.expiryDate > pwh2.expiryDate  ? warehouse1.poll() : warehouse2.poll();
                }
            } else {
                return null;
            }
        }
    }

class Consumer {
    String name;

    public Consumer(String name) {
        this.name = name;
    }

    public void buyProduct(Store store) {
        Product product = store.getProduct();
        if (product != null) {
            System.out.println(name + " bought " + product.name + " with expiry date of " + product.expiryDate + " days.");
        } else {
            System.out.println("Sorry, no more products available.");
        }
    }
}




