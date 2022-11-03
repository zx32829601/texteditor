package command;

public class FontStyleOneCommand extends Command{
    public FontStyleOneCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.fontStyleOne();
    }
}
