package homework20240605;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
// Доделать класс lesson20240605.CarProduction с моделью конвейера
//1 поток производит корпус автомобиля ----> класс CarBody
//2 поток производит колеса ----> класс Wheel
//3 поток собирает из 4 колес и одного корпуса автомобиля готовый автомобиль ----> класс Car = 4 Wheel + 1 CarDetail

public class CarProduction {

    static class Wheel {
    }

    static class CarBody {
    }

    static class Car {
        List<Wheel> wheels;
        CarBody carDetail;

        public Car(List<Wheel> wheels, CarBody carDetail) {
            this.wheels = wheels;
            this.carDetail = carDetail;
        }
    }

    static class WheelProduction implements Runnable {

        private BlockingQueue<Wheel> wheelBlockingQueue;

        public WheelProduction(BlockingQueue<Wheel> wheelBlockingQueue) {
            this.wheelBlockingQueue = wheelBlockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                Wheel wheel = new Wheel();
                try {
                    wheelBlockingQueue.put(wheel);
                    System.out.println("Produced one wheel");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CarBodyProduction implements Runnable {
        private BlockingQueue<CarBody> carBodyBlockingQueue;

        public CarBodyProduction(BlockingQueue<CarBody> carBodyBlockingQueue) {
            this.carBodyBlockingQueue = carBodyBlockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                CarBody carBody = new CarBody();
                try {
                    carBodyBlockingQueue.put(carBody);
                    System.out.println("Produced one car body");
                    Thread.sleep(25000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ReadyMadeCar implements Runnable {

        private BlockingQueue<Wheel> wheels;
        private BlockingQueue<CarBody> carBodies;
        private List<Car> cars;


        public ReadyMadeCar(BlockingQueue<Wheel> wheels, BlockingQueue<CarBody> carBodies) {
            this.wheels = wheels;
            this.carBodies = carBodies;
            this.cars = new ArrayList<>();

        }

        @Override
        public void run() {
            while (true) {
                try {
                    CarBody carBody = carBodies.take();
                    List<Wheel> wheels4 = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        wheels4.add(wheels.take());
                    }
                    Car car = new Car(wheels4, carBody);
                    cars.add(car);
                    System.out.println("The car is made of one car body and " + wheels4.size() + " wheels");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    public static void main(String[] args) {
        BlockingQueue<Wheel> wheelBlockingQueue = new ArrayBlockingQueue<>(20);
        BlockingQueue<CarBody> carBodyBlockingQueue = new ArrayBlockingQueue<>(5);


        new Thread(new WheelProduction(wheelBlockingQueue)).start();
        new Thread(new CarBodyProduction(carBodyBlockingQueue)).start();
        new Thread(new ReadyMadeCar(wheelBlockingQueue, carBodyBlockingQueue)).start();

    }
}

