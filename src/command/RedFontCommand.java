package command;

public class RedFontCommand extends Command{
    public RedFontCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.redFont();
    }
}
