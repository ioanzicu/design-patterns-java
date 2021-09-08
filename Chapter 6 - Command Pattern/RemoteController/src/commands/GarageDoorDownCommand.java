package commands;
import receivers.GarageDoor;

public class GarageDoorDownCommand implements Command {
    GarageDoor door;

    public GarageDoorDownCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.down();
    }

    @Override
    public void undo() {
        door.up();
    }
}
