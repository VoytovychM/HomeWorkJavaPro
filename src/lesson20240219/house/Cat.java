package lesson20240219.house;

public class Cat extends Animal {

    public Cat(String catName){
        this(catName, "white", 1);
    }

    public Cat(String catName, String catColour, int catAge){
        super(catName, catColour, catAge);
    }

    public void sayHello(){
        System.out.println("Meow! I'm cat. My name is " + super.getName());
    }

    public void meow() {
        System.out.println("Meow!");
    }
    public void run (){
        System.out.println("Cat " + getName() + " runs away ");
    }

    public void play(Creature  another){
        Animal anotherAnimal = (Animal) another;
        System.out.println("Cat " + getName() + " plays with  " + anotherAnimal.getName() );
        if (another instanceof Dog){
            run();
        }
    }
}
