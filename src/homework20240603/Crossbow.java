package homework20240603;

import java.util.Scanner;

//См. класс Crossbow в репозитории.
//Стрелок robinHood в одном потоке стреляет из арбалета,
//его помощник servant в другом потоке приносит ему колчан, когда стрелы закончатся.
//Заготовка логики в классе Crossbow. Доработать логику, чтобы: стрельба продолжалась бесконечно
//количество приносимых стрел каждый раз определял бы пользователь, вводя число arrows через консоль
public class Crossbow {

    private int arrows = 3;


    public void fire() {
        while (true) {
            synchronized (this) {
                for (int idx = arrows; idx > 0; idx--) {
                    System.out.println("The arrow " + (arrows - idx + 1) + " is right on the target!");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("The arrows are over");
                arrows = 0;
                System.out.println("Count arrows = " + arrows);
                try {
                    this.notify();
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Carry a new quiver with arrows!!");
            }
        }
    }
    // reload() brings new arrows, calls the notify() method, which awakens the thread
    public void reload() {
        while (true) {
            synchronized (this) {


            System.out.println("Enter the number of arrows to reload: ");
            Scanner scanner = new Scanner(System.in);
            int newArrows = scanner.nextInt();
            System.out.println("New arrows on the way!");
            arrows = newArrows;
            System.out.println("Count arrows = " + arrows);
            System.out.println("Enter the number of arrows to reload: ");
            this.notify();

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        }


    public static void main(String[] args) {

        Crossbow crossbow = new Crossbow();

        Thread robinHood = new Thread(crossbow::fire);
        Thread servant = new Thread(crossbow::reload);

        robinHood.start();
        servant.start();
    }
}
