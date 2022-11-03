package command;

public class FontStyleTwoCommand extends Command{
    public FontStyleTwoCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.fontStyleTwo();
    }
}
