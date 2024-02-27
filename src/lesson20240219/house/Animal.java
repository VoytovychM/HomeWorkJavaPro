package lesson20240219.house;

public abstract class Animal extends Creature implements Ageable{


    private String colour;

    private int age;

    private boolean isHungry;

    public Animal(String name, String colour, int age) {
       super (name);
        this.colour = colour;
        this.age = age;
        this.isHungry = true;
    }

    public void feed(){
        isHungry = false;
        System.out.println("Animal " + getName() + " is not hungry anymore");
    }

    public abstract void sayHello();

    public void displayAnimalInfo(){
        System.out.println("Animal info:");
        System.out.println(getName() + ", colour: " + colour + ", age: " + age + ", isHungry: " + isHungry);
        sayHello();
        System.out.println("--------------");
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public boolean isHungry() {

        return isHungry;
    }

    public void setHungry(boolean hungry) {

        isHungry = hungry;
    }

    @Override
    public void grow() {
        age++;
    }
}
