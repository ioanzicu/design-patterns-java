import commands.LightOnCommand;
import commands.StereoOffCommand;
import commands.StereoOnWithCDCommand;
import commands.CeilingFanLowCommand;
import commands.CeilingFanMediumCommand;
import commands.CeilingFanHighCommand;
import commands.GarageDoorDownCommand;
import commands.CeilingFanOffCommand;
import commands.Command;
import commands.LightOffCommand;

import invoker.RemoteControl;
import invoker.RemoteControlWithUndo;
import macro.MacroCommand;
import receivers.CeilingFan;
import receivers.GarageDoor;
import receivers.Light;

import receivers.Stereo;

public class RemoteLoader {
    
    public static void main(String[] args) {
        // TEST 1
        // RemoteControl remoteControl = new RemoteControl();

        // Light livingRoomLight = new Light("Living Room");
        // Light kitchenLight = new Light("Kitchen");
        // CeilingFan ceilingFan = new CeilingFan("Living Room");
        // GarageDoor garageDoor = new GarageDoor("");
        // Stereo stereo = new Stereo("Living Room");

        // LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        // LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        // LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        // LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        // CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        // CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // GarageDoorDownCommand garageDoorUp = new GarageDoorDownCommand(garageDoor);
        // GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);

        // StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        // StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        // remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        // remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        // remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        // remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
        // remoteControl.setCommand(4, stereoOnWithCD, stereoOff);


        // System.out.println(remoteControl);

        
        // remoteControl.onButtonWasPushed(0);
        // remoteControl.offButtonWasPushed(0);
        
        // remoteControl.onButtonWasPushed(1);
        // remoteControl.offButtonWasPushed(1);

        // remoteControl.onButtonWasPushed(2);
        // remoteControl.offButtonWasPushed(2);
        
        // remoteControl.onButtonWasPushed(3);
        // remoteControl.offButtonWasPushed(3);

        // remoteControl.onButtonWasPushed(4);
        // remoteControl.offButtonWasPushed(4);




        // TEST 2
        // System.out.println("\n\n--- TEST UNDO ---\n");
        // RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        // Light livingRoomLight2 = new Light("Living Room");
        // LightOnCommand livingRoomLightOn2 = new LightOnCommand(livingRoomLight2);
        // LightOffCommand livingRoomLightOff2 = new LightOffCommand(livingRoomLight2);

        // remoteControlWithUndo.setCommand(0, livingRoomLightOn2, livingRoomLightOff2);

        
        // remoteControlWithUndo.onButtonWasPushed(0);
        // remoteControlWithUndo.offButtonWasPushed(0);
        // System.out.println(remoteControlWithUndo);
        // remoteControlWithUndo.undoButtonWasPushed();
        // System.out.println("\n");
        
        // remoteControlWithUndo.offButtonWasPushed(0);
        // remoteControlWithUndo.onButtonWasPushed(0);
        // System.out.println(remoteControlWithUndo);
        // remoteControlWithUndo.undoButtonWasPushed();
        // System.out.println("\n");



        // TEST 3
        // System.out.println("\n\n--- TEST Ceiling Fan ---\n");
        // RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();

        // CeilingFan ceilingFan = new CeilingFan("Living Room");

        // CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        // CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        // CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // remoteControlWithUndo.setCommand(0, ceilingFanMedium, ceilingFanOff);
        // remoteControlWithUndo.setCommand(1, ceilingFanHigh, ceilingFanOff);

        // remoteControlWithUndo.onButtonWasPushed(0);
        // remoteControlWithUndo.offButtonWasPushed(0);
        // System.out.println(remoteControlWithUndo);
        // remoteControlWithUndo.undoButtonWasPushed();

        // remoteControlWithUndo.onButtonWasPushed(1);
        // System.out.println(remoteControlWithUndo);
        // remoteControlWithUndo.undoButtonWasPushed();
        // System.out.println("\n");




        // TEST 4
        System.out.println("\n\n--- TEST Macro Command ---\n");

        RemoteControlWithUndo remoteControlWithUndo = new RemoteControlWithUndo();
        Light light = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");
        
        LightOnCommand lightOn = new LightOnCommand(light);
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);

        LightOffCommand lightOff = new LightOffCommand(light);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        Command[] partyOn = { lightOn, stereoOn };
        Command[] partyOff = { lightOff, stereoOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControlWithUndo.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remoteControlWithUndo);
        System.out.println("\n--- Pushing Macro On ---");
        remoteControlWithUndo.onButtonWasPushed(0);
        System.out.println("\n--- Pushing Macro Off ---");
        remoteControlWithUndo.offButtonWasPushed(0);


        System.out.println("\n\n--- TEST Macro Command UNDO---\n");
        remoteControlWithUndo.undoButtonWasPushed();
    }
}
