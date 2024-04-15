package homework20240410;

import java.util.function.BiFunction;

public class Exponent {
    public static void main(String[] args) {
        BiFunction<Double, Double, Double> exponent = (arg, exp)-> {
            return Math.pow(arg, exp);
        };

        System.out.println(exponent.apply(4d,5d));
        System.out.println(exponent.apply(2d,3d));
    }

}
