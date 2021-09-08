import controller.ControllerInterface;
import controller.heart.HeartController;
import model.heart.HeartModel;

public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface model = new HeartController(heartModel);
    }
}
