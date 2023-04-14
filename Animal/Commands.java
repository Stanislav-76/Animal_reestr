package Animal;

import java.util.ArrayList;
import java.util.List;

public class Commands {
    List<Command> commands;
    Command command;

    public Commands() {
        this.commands = new ArrayList<>();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public enum Command {
        GO, STOP, RUN_AWAY, COME_UP, LIE, JUMP, TRUP, STAND_UP
    }

    @Override
    public String toString() {
        String res = "";
        for (Command command : commands) {
            res += command + " ";
        }
        return res;
    }
}