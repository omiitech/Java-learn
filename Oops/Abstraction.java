abstract class Animal {
    abstract void makeSound();
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.makeSound();  // Outputs: Meow
    }
}