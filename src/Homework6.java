/*
 * Java1. Homework6
 *
 * @author Zhuravlev.k
 * @version 28.10.2021
 */

public class Homework6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Черныш", 200, 0);
        Cat cat2 = new Cat("Огнегрив", 200, 0);
        Dog dog1 = new Dog("Бусый", 500, 10);
        Dog dog2 = new Dog("Диваногрыз", 500, 10);

        IAnimal[] animals = {cat1, cat2, dog1, dog2};
        for (IAnimal animal : animals) {
            System.out.println("______________________________________\n" + animal);
            System.out.println(animal.run(200));
            System.out.println(animal.run(600));
            System.out.println(animal.swim(10));
            System.out.println(animal.swim(11));
        }
        System.out.println("______________________________________\n" +
                "Количество животных: " + Animal.getNumAnimal());
    }
}

interface IAnimal {
    String run(int distance);

    String swim(int distance);
}

class Cat extends Animal {
    Cat(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
    }

    @Override
    public String swim(int distance) {
        return name + ": Мяяяуу! Сам в воду лезь, двуногий!";
    }
}

class Dog extends Animal {
    Dog(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
    }
}

abstract class Animal implements IAnimal {
    protected String name;
    private int limitRun;
    private int limitSwim;
    private static int numAnimal = 0;

    Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        numAnimal++;
    }

    public static int getNumAnimal() {
        return numAnimal;
    }

    @Override
    public String run(int distance) {
        if (distance > limitRun) {
            return name + ": Я тебе что лошадь? " + distance + "м точно пробежать не смогу";
        } else {
            return name + ": Легко " + distance + "м пробегу";
        }
    }

    @Override
    public String swim(int distance) {
        if (distance > limitSwim) {
            return name + ": Ты что дельфина нашел? Я " + distance + "м проплыть не смогу";
        } else {
            return name + ": Легко " + distance + "м проплыву";
        }
    }

    @Override
    public String toString() {
        return "MaxRun:  " + limitRun + "м \nMaxSwim: " + limitSwim + "м";
    }
}
