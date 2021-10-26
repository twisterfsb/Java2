/*
 * Java1. Homework5
 *
 * @author Zhuravlev.k
 * @version 27.10.2021
 */

public class Homework5 {

    public static void main(String[] args) {
        Person[] personDB = new Person[7];
        personDB[0] = new Person("Жарков Алексей Алексеевич", "Техдир", "zharkov.a@mail.ru", "+79991112223", 100000, 39);
        personDB[1] = new Person("Журавлев Андрей Михайлович", "Аналитик", "zhuravlev.a@mail.ru", "+79882223344", 90000, 24);
        personDB[2] = new Person("Железняков Михаил Анатольевич", "Электромонтер", "zheleznyakov.m@mail.ru", "+79773334455", 70000, 37);
        personDB[3] = new Person("Солянкина Ксения Владимировна", "Контроллер ОТК", "solyankina.k@mail.ru", "+79664445566", 60000, 27);
        personDB[4] = new Person("Мотовилова Александра Максимовна", "Гендир", "motovilova.a@mail.ru", "+79555556677", 120000, 46);
        personDB[5] = new Person("Дмитриев Владимир Антонович", "Менеджер по развитию", "dmitriev.v@mail.ru", "+79446667788", 80000, 41);
        personDB[6] = new Person("Буржев Сергей Александрович", "Ковырятель в носу", "burzhuev.s@mail.ru", "+79337778899", 15000, 18);

        for (Person item : personDB) {
            if (item.getAge() > 40) System.out.println(item.personInfo());
        }
    }
}

class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    Person(String fio, String position, String email, String phone, double salary, int age) {
        this.fullName = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    public String personInfo() {
        return fullName + " || " + position + " || " + email + " || " + phone + " || " + salary + " || " + age;
    }
}