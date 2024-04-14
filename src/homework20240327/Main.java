package homework20240327;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        store.addProduct(new Product("Milk", 5), 2);
        store.addProduct(new Product("Bread", 7), 1);
        store.addProduct(new Product("Apples", 10), 1);
        Consumer consumer1 = new Consumer("Alex");
        Consumer consumer2 = new Consumer("Maria");

        consumer1.buyProduct(store);
        consumer2.buyProduct(store);
        consumer1.buyProduct(store);
        consumer2.buyProduct(store);
    }
}
