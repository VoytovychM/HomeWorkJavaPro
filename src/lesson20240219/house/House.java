package lesson20240219.house;

public class House {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", "white", 2);
        Cat cat2 = new Cat("Vasya", "black", 1);
        cat1.sayHello();
        cat2.sayHello();

//        System.out.println(cat1.isHungry());
//        cat1.feed();
//        System.out.println(cat1.isHungry());

//        Robot.printTotalRobotCount();
//
//        Robot robot1 = new Robot("Valuum cleaner", "Robot cleaner");
//        Robot robot2 = new Robot("Washing mashine", "Robot to wash something");
//        robot1.printCurrentRobotInfo();
//        robot2.printCurrentRobotInfo();
//
////        robot1.printTotalRobotCount();
////        robot2.printTotalRobotCount();
//        Robot.printTotalRobotCount();

        Dog dog = new Dog("Jack", "grey", 1);
        dog.bark();
        dog.sayHello();
//        dog.feed();

        Animal animal = dog;
        animal.displayAnimalInfo();
        animal = cat1;
        animal.displayAnimalInfo();

//        Animal animal = new Animal("Jack", "grey", 1);

        Human human = new Human("Harry");
//        human.feedAnimal(dog);
        human.feedAnimal(dog, cat1, cat2);
        dog.play(cat1);
        cat1.play(dog);

        human.walk(dog);

    }


}
