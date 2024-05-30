package homework20240529;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

//Спортивное соревнование. Бегут 3 бегуна. Каждый пробегает дистанцию за случайное время.
//Каждый бегун земеряет свой результат и сообщает его тренеру. В конце забега выводится информация о победителе.
//Реализовать данную модель с помощью запуска отдельных потоков. Бегуна представить через класс Runner implements Runnable.
public class Competition {
        public static Runner getWinner (List<Runner> runnerList){
            Runner winner = runnerList.stream().min(Comparator.comparing(Runner::getResult )).orElseThrow(RuntimeException::new);
           return winner;
        }
    public static void main(String[] args) {
            Bridge bridge = new Bridge();
        Runner runner1 = new Runner("Lion", bridge);
        Runner runner2 = new Runner("Leopard", bridge);
        Runner runner3 = new Runner("Panther", bridge);
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);
        thread1.start();
        thread2.start();
        thread3.start();


        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(runner1.name + " result: " + runner1.getResult());
        System.out.println(runner2.name + " result: " + runner2.getResult());
        System.out.println(runner3.name + " result: " + runner3.getResult());
        Runner winner = getWinner(List.of(runner1, runner2, runner3));
        System.out.println(winner.name + " won!");
    }

    static class Bridge {

            public synchronized void runOverTheBridge(Runner runner){
                System.out.println(runner.name + " started to run over the bridge. ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(runner.name + " crossed the bridge. ");
            }
    }
    static class Runner implements Runnable{
        long result;
        String name;

        Bridge bridge;

        public Runner(String name, Bridge bridge) {
            this.name = name;
            this.bridge = bridge;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            System.out.println(name + " started to run in " + Thread.currentThread().getName());
            try {
                Random random = new Random();
                Thread.sleep(10_000+random.nextInt(10_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.bridge.runOverTheBridge(this);
            System.out.println(name + " finished to run in " + Thread.currentThread().getName());
            long end = System.currentTimeMillis();
            setResult(end-start);
        }

        public long getResult() {
            return result;
        }

        public void setResult(long result) {
            this.result = result;
        }
    }
}
