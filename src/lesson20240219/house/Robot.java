package lesson20240219.house;

public class Robot extends Creature  implements MouseCatcher{

    private static int robotCount = 0;

    private static final int ROBOT_DEFAULT_VERSION = 1;



    private String description;

    private int version;

    public Robot(String name, String description, int version) {
        super (name);
        this.description = description;
        this.version = version;
        robotCount++;
    }

    public Robot(String name, String description) {
       super (name);
        this.description = description;
        this.version = ROBOT_DEFAULT_VERSION;
        robotCount++;
    }

    public static void printTotalRobotCount(){
//        System.out.println(this.name); impossible
        System.out.println("Total robot number = " + robotCount);
    }

    public void printCurrentRobotInfo() {
        System.out.println(getName() + ", description: " + description + ", version: " + version);
        System.out.println("Total robot number = " + robotCount);
    }



    @java.lang.Override
    public void sayHello() {
    printCurrentRobotInfo();
    }

    public void walk (Animal animal){
        String animalType = "";
        if(animal instanceof Cat){
            animalType = "Cat";
        } else if (animal instanceof Dog) {
            animalType = "Dog";
        }
        System.out.println("Robot " + this.getName() + " is walking with " + animalType + " " + animal.getName());
    }

    @Override
    public void catchMouse(Mouse mouse) {
        System.out.println("Robot " + this.getName() + " is catching mouse " + mouse.getName());;
    }
}
