package homework20240617;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private List<Order> orders = new ArrayList<>();

    public void processOrder(String customerId, List<String> itemIds, String shippingMethod) {

        if (!("standard".equals(shippingMethod) || "express".equals(shippingMethod))) {
            println("Invalid shipping method");
            return;
        }

        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            println("Customer not found");
            return;
        }

//        List<Item> items = new ArrayList<>();
//        for (String itemId : itemIds) {
//            Item item = getItemById(itemId);
//            if (item != null) {
//                items.add(item);
//            } else {
//                println("Item not found: " + itemId);
//            }
//        }
        List<Item> items = itemIds.stream().filter(i-> getItemById(i) != null).map(i-> getItemById(i)).toList();
        if (items.isEmpty()) {
            println("No valid items found for order");
            return;
        }

        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getPrice();
        }

        double shippingCost = 0;
        if ("standard".equals(shippingMethod)) {
            shippingCost = 5.99;
        } else if ("express".equals(shippingMethod)) {
            shippingCost = 9.99;
        } else {
            println("Invalid shipping method");
            return;
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setItems(items);
        order.setTotalAmount(totalAmount);
        order.setShippingCost(shippingCost);
        order.setOrderStatus("Processing");

        orders.add(order);
        println("Order processed: " + order.getId());
    }

    public void cancelOrder(long orderId) {
        Order orderToRemove = getOrder(orderId);
        if (orderToRemove != null) {
            orders.remove(orderToRemove);
            println("Order canceled: " + orderToRemove.getId());
        } else {
            println("Order not found: " + orderId);
        }
    }

    public void printOrderDetails(long orderId) {
        Order foundOrder = getOrder(orderId);
        if (foundOrder != null) {
            println("Order Details: ");
            println("Customer: " + foundOrder.getCustomer().getName());
            println("Items: ");
            for (Item item : foundOrder.getItems()) {
                println(" - " + item.getName() + ": $" + item.getPrice());
            }
            println("Total Amount: $" + foundOrder.getTotalAmount());
            println("Shipping Cost: $" + foundOrder.getShippingCost());
            println("Status: " + foundOrder.getOrderStatus());
        } else {
            println("Order not found: " + orderId);
        }
    }

    private Order getOrder(long orderId) {
        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getId() == orderId) {
                foundOrder = order;
                break;
            }
        }
        return foundOrder;
    }

    public void println(String message) {
        System.out.println(message);
    }

    private Customer getCustomerById(String customerId) {
        // Simulated method to get customer by ID
        return new Customer(customerId, "Customer Name");
    }

    private Item getItemById(String itemId) {
        // Simulated method to get item by ID
        return new Item(itemId, "Item Name", Math.random() * 100);
    }
}

