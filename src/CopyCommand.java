public class CopyCommand extends Command {

    public CopyCommand(ReceiverCommand receiverCommand) {
        super(receiverCommand);
    }
    public void execute() {
        receiverCommand.copy();
    }

}