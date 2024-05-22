package homework20240517;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatingValuesTest {

    @Test
   public void testRemoveRepeatingValuesWhenInputIsNull() {
       int[] expected = new int[0];
       int[] result = RepeatingValues.removeRepeatingValues(null);
       assertArrayEquals(expected, result);

       result = RepeatingValues.removeRepeatingValues(new int[0]);
       assertArrayEquals(expected, result);

    }
    @Test
    public void testRemoveRepeatingValuesPositive1(){
       int[] expected = new int[]{0,3,-2,4,2};
       int[] result = RepeatingValues.removeRepeatingValues(new int[]{0,3,-2,4,3,2});
       assertArrayEquals(expected, result);

    }
    @Test
    public void testRemoveRepeatingValuesPositive2(){
        int[] expected = new int[]{0,3,-2,4,2 };
        int[] result = RepeatingValues.removeRepeatingValues(new int[]{0,3,-2,4,2});
        assertArrayEquals(expected, result);
}
    @Test
    public void testRemoveRepeatingValuesNegativeValues(){
        int[] expected = new int[]{0,3,-2,4};
        int[] result = RepeatingValues.removeRepeatingValues(new int[]{0,3,-2,4,-2});
        assertArrayEquals(expected, result);
}
}