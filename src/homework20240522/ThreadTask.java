package homework20240522;

public class ThreadTask {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long start = System.currentTimeMillis();


        int number = 5;
        int count = 0;

        RangeCalculater rangeCalculater1 = new RangeCalculater(Integer.MIN_VALUE, 0, number);
        RangeCalculater rangeCalculater2 = new RangeCalculater(0, Integer.MAX_VALUE, number);
        // System.out.println(Integer.MIN_VALUE + " " + " " + Integer.MAX_VALUE); -2147483648  2147483647
        rangeCalculater1.start();
        rangeCalculater2.start();


        try {
            rangeCalculater1.join();
            rangeCalculater2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count = rangeCalculater1.getCount() + rangeCalculater2.getCount();

        long end = System.currentTimeMillis();

        System.out.println("Total divisible by " + number + ":" + count);
        System.out.println("Time elapsed: " + (end - start) + ", ms");
    }

    static class RangeCalculater extends Thread{

        int start;
        int end;
        int count =0;
        int divider;

        public RangeCalculater(int start, int end, int divider) {
            this.start = start;
            this.end = end;
            this.divider = divider;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            for(int i = start; i < end; i++){
                if(i % divider == 0)
                    count ++;
            }

        }
    }
}
