public class PasteCommand extends Command {

    public PasteCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.paste();
    }

}