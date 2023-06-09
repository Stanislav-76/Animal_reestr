import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Animal.Animal;
import Animal.Commands.Command;
import Animal.PackAnimals.*;
import Animal.PetAnimals.*;

public class Program {
    public static void main(String[] args) {
        // Dog dog = new Dog("Собака","11.01.2023");
        // dog.addCommands(Command.GO);
        // dog.addCommands(Command.COME_UP);
        // System.out.println(dog);

        ReestrAnimal reestr = new ReestrAnimal();
        int i = 0;
        while (true) {
            System.out.println("1. Завести животное 2. Вывести реестр 3. Обучить животное команде 4. Выход");
            System.out.print("Введите номер: ");
            Scanner sc = new Scanner(System.console().reader());
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                sc.close();
            } else {
                System.out.println("Неверный ввод");
            }
            if (i == 1) {
                reestr.addAnimal(createAnimal());
            }
            if (i == 2) {
                reestr.viewReestr();
            }
            if (i == 3) {
                learnAnimalSkill(reestr);;
            }
            if (i == 4) {
                break;
            }
        }
    }

    public static Animal createAnimal() {
        int i = 0;
        System.out.println("1. Собака 2. Кошка 3. Хомяк 4. Лошадь 5. Осел 6. Верблюд");
        System.out.println("Введите номер: ");
        Scanner scan = new Scanner(System.console().reader());
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            scan.nextLine();
        } else {
            System.out.println("Неверный ввод");
        }
        if (i >= 1 && i <= 6) {
            System.out.println("Введите имя: ");
            String name = scan.nextLine();        
            System.out.println("Введите дату рождения (dd.mm.yyyy): ");
            String date = scan.nextLine();
            scan.close();
            if (!date.matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)[0-9][0-9])") || !isThisDateValid(date)) {
                System.out.println("Дата введена неверно! Операция прервана, повторите заново.");
                return null;
            }
            if (i == 1) {
                return new Dog(name, date);
            }
            if (i == 2) {
                return new Cat(name, date);
            }
            if (i == 3) {
                return new Hamster(name, date);
            }
            if (i == 4) {
                return new Horse(name, date);
            }
            if (i == 5) {
                return new Donkey(name, date);
            }
            if (i == 6) {
                return new Camel(name, date);
            }
        }
        scan.close();
        return null;
    }

    public static boolean isThisDateValid(String dateToValidate) {
    if (dateToValidate == null) {
        return false;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    sdf.setLenient(false);
    try {
        // if not valid, it will throw ParseException
        Date date = sdf.parse(dateToValidate);
        if(!date.before(new Date())){   // Проверка не более текущей даты
            return false;
        }
        // System.out.println(date); // Sat Apr 30 00:00:00 MSK 2022
    } catch (ParseException e) {
        // e.printStackTrace();
        return false;
    }
    return true;
    }


    public static void learnAnimalSkill(ReestrAnimal reestr) {
        int i;
        System.out.println("Выберите животное:");
        reestr.viewReestr();
        System.out.println("Введите номер: ");
        Scanner scan = new Scanner(System.console().reader());
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            scan.nextLine();
        } else {
            System.out.println("Неверный ввод");
            return;
        }
        Animal animal;
        if (i > 0 && i <= reestr.animals.size()) {
            animal = reestr.animals.get(i-1);
        } else {
            System.out.println("Неверный ввод");
            return;
        }
        i = 1;
        for (Command item : Command.values()) {
            System.out.println(i++ + " " + item);
        }
        System.out.println("\nВыберите навык: ");
        if (scan.hasNextInt()) {
            i = scan.nextInt();
            scan.nextLine();
        } else {
            System.out.println("Неверный ввод");
            return;
        }
        if (i >=1 && i <= Command.values().length) {
            for (Command item : Command.values()) {
                if (i == item.ordinal() + 1) {
                    animal.addCommands(item);
                }
            }            
        }
    }
}

class ReestrAnimal {
    List<Animal> animals;
    Count count;

    public ReestrAnimal() {
        animals = new ArrayList<>();
        count = new Count();
    }

    public void addAnimal(Animal animal) {
        if (animal != null) {
            this.animals.add(animal);
            count.add();
        }
    }

    public void viewReestr() {
        int i = 1;
        for (Animal animal : animals) {
            System.out.println(i++ + " " + animal);
        }
    }

    @Override
    public String toString() {
        return "[animals=" + animals + "]";
    }
}