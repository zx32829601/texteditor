package command;

public class FontStyleThreeCommand extends Command{
    public FontStyleThreeCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.fontStyleThree();
    }
}
