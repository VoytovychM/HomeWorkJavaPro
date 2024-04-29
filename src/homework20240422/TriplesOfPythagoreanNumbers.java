package homework20240422;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Составить все возможные тройки пифагоровых чисел от 1 до 1000
//Пифагоровой тройкой называют три натуральных числа, из которых можно составить прямоугольный треугольник
//a^2 + b^2 = c^2
//[3, 4, 5]
//[6, 8, 10]
public class TriplesOfPythagoreanNumbers {
    public static void main(String[] args) {

        List<Triplet> result = IntStream.rangeClosed(1, 1000).boxed() // кубическая сложность
                .flatMap(hyp -> IntStream.range(1, hyp).boxed()
                        .flatMap(side1 -> IntStream.rangeClosed(1, side1)
                                .mapToObj(side2 -> new Triplet(side2, side1, hyp))))
                .filter(Triplet::isPythagoreanTriple).collect(Collectors.toList());
        System.out.println(result);

            List<Integer[]> triples = IntStream.rangeClosed(1, 1000).boxed().flatMap(i -> IntStream.rangeClosed(i, 1000).filter(j -> Math.sqrt(i*i+j*j)%1 ==0)
                           .mapToObj(j -> new Integer[]{i, j, (int) Math.sqrt(i*i+j*j)})).toList(); // квадратичная сложность

        triples.forEach(e-> System.out.println(Arrays.toString(e)));
    }

    static class Triplet {
        private Integer a;
        private Integer b;
        private Integer c;

        public Triplet(Integer a, Integer b, Integer c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public Integer getB() {
            return b;
        }

        public void setB(Integer b) {
            this.b = b;
        }

        public Integer getC() {
            return c;
        }

        public void setC(Integer c) {
            this.c = c;
        }

        boolean isPythagoreanTriple() {
            return Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2);
        }

        @Override
        public String toString() {
            return "[" + a + "," + b + "," + c + "]";
        }
    }
}
