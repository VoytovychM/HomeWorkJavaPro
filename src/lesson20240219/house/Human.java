package lesson20240219.house;

import static java.lang.System.*;

public class Human extends Creature implements Ageable {

    private String name;
    private int age;

    public Human(String name, int age) {
        super(name);
        this.age = age;
    }

    public void feedAnimal(Animal animal) {
        animal.feed();
    }

    public void feedAnimal(Animal... animals) {
        for (Animal a : animals) {
            a.feed();
        }
    }

    @Override
    public void sayHello() {
        System.out.println("Hello! I'm human. My name is" + name);
    }

    public void walk(Animal animal) {
        String animalType = "";
        if(animal instanceof Cat){
            animalType = "Cat";
        } else if(animal instanceof Dog) {
            animalType = "Dog";
        }
        System.out.println("Human " + this.getName() + " is walking with " + animalType + " " + animal.getName());
        animal.setHungry(true);
    }

    @Override
    public void grow() {
      age++;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
