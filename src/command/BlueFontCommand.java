package command;

public class BlueFontCommand extends Command{
    public BlueFontCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.blueFont();
    }

}
