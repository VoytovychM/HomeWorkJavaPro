package homework20240517;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopKTaskTest {


    @Test
    public void testTopKWithPriorityQueueWhenItemsNull() {
        List<TopKTask.Item> result = TopKTask.topKWithPriorityQueue(null, 1);
       List<TopKTask.Item> expected = List.of();
       assertEquals(expected, result);
    }
    @Test
    public void testTopKWithPriorityQueueWhenItemsWhenKMinusOne() {
        List<TopKTask.Item> result = TopKTask.topKWithPriorityQueue(getDefaultItems(), -1);
        List<TopKTask.Item> expected = List.of();
        assertEquals(expected, result);
    }
    @Test
    public void testTopKWithPriorityQueueWithNormalValues() {
        List<TopKTask.Item> result = TopKTask.topKWithPriorityQueue(getDefaultItems(), 3);
        List<TopKTask.Item> expected = List.of(new TopKTask.Item("Toy3", 12),new TopKTask.Item("Toy5", 23),new TopKTask.Item("Doll", 25));
        assertEquals(expected, result);
    }
    private List<TopKTask.Item> getDefaultItems (){
        List<TopKTask.Item> items = Arrays.asList(new TopKTask.Item("Book", 100),
                new TopKTask.Item("Toy1", 50),
                new TopKTask.Item("Toy2", 50),
                new TopKTask.Item("Toy3", 12),
                new TopKTask.Item("Toy4", 32),
                new TopKTask.Item("Toy5", 23),
                new TopKTask.Item("Toy6", 50),
                new TopKTask.Item("Doll", 25));
        return items;
    }
}