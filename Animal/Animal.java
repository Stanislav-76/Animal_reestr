package Animal;
import Animal.Commands.Command;

public abstract class Animal {
    int number;
    String name;    
    String dateOfBirth;
    Commands commands;
    
    public Animal(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commands = new Commands();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void addCommands(Command command){
        this.commands.addCommand(command);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " Имя: " + name + " Дата рождения: " + dateOfBirth + " Навыки: " + commands;
    }
}