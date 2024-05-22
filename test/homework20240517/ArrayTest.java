package homework20240517;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    public void findCommonElements() {

            int[] array1 = {1, 2, 5, 5, 8, 9, 7, 10};
            int[] array2 = {1, 0, 6, 15, 6, 4, 7, 0};

            Set<Integer> expectedOutput = Set.of(1, 7);
            Set<Integer> result = Array.findCommonElements(array1, array2);
            assertEquals(expectedOutput, result);

        assertTimeout(Duration.ofMillis(1), () -> Array.findCommonElements(new int[]{1, 3, 6, 8, 9}, new int[]{0, 2, 22, 5, 9}));
    }
    }
