package lesson20240219.house;

public class Human extends Creature {

    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void feedAnimal(Animal animal) {
        animal.feed();
    }

    public void feedAnimal(Animal... animals) {
        for (Animal a : animals) {
            a.feed();
        }
    }


    @java.lang.Override
    public void sayHello() {

    }
    public void walk(Animal animal){
        animal.setHungry(true);
        System.out.println(animal.getName() + " walked for one hour ");


        if (animal.isHungry()){
            System.out.println(animal.getName() + " is hungry");
        } else {
            System.out.println(animal.getName() + "is not hungry");
        }

    }
}
