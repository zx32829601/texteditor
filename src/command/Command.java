package command;

public abstract class Command {

    ReceiverCommand receiverCommand;
    public abstract void execute();
    public Command(ReceiverCommand receiverCommand){
        this.receiverCommand = receiverCommand;
    }
}