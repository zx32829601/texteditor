package command;

import java.util.ArrayList;
import java.util.List;

public class InvokerCommand {
    List<Command>commandList = new ArrayList<Command>();

    public void addCommend(Command command) {
        commandList.add(command);
    }
    public void execute() {
        for(Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }

}