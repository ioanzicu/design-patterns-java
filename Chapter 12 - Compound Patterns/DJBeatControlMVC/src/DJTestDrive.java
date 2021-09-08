import controller.ControllerInterface;
import controller.beat.BeatController;
import model.beat.BeatModel;
import model.beat.BeatModelInterface;

public class DJTestDrive {
    public static void main(String[] args) throws Exception {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
