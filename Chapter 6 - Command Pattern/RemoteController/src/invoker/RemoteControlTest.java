package invoker;

import commands.GarageDoorDownCommand;
import commands.LightOnCommand;
import receivers.GarageDoor;
import receivers.Light;

public class RemoteControlTest {
    public static void main(String[] args) throws Exception {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("");
        LightOnCommand lightOn = new LightOnCommand(light);
        
        remote.setCommand(lightOn);
        remote.buttonWasPressed();
        


        GarageDoor garageDoor = new GarageDoor("");
        GarageDoorDownCommand garageOpen = new GarageDoorDownCommand(garageDoor);

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
