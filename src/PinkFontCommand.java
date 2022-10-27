public class PinkFontCommand extends Command{
    public PinkFontCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.pinkFont();
    }
}
