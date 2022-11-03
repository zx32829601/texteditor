package command;

public class CutCommand extends Command {

    public CutCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.cut();
    }

}