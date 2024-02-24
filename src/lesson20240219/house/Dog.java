package lesson20240219.house;

public class Dog extends Animal {

    public Dog(String name, String colour, int age) {
        super(name, colour, age);
    }

    @Override
    public void sayHello() {
        System.out.println("Gav! I'm dog. My name is " + super.getName());
    }

    public void bark() {
        System.out.println("Dog " + getName() + " Gav! Gav! ");
    }

    public void play(Creature  another){
        Animal anotherAnimal = (Animal) another;
        System.out.println("Dog " + getName() + " plays with  " + anotherAnimal.getName() );
        if(another instanceof Cat ){
            this.bark();
        }
    }

}
