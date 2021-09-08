## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


To run the RMI:

1. Compile the classes `GumballMachineTestDrive` and `GumballMonitorTestDrive`:

    `javac GumballMachineTestDrive`

    `javac GumballMonitorTestDrive`

2. Open the file explorer in the `GumballMachineWithMonitor/src` folder

3. Open a **cmd** or **bash** terminal and type `rmiregistry`, the window should not print any output, just shows that the process is running

4. Open another **cmd** or **bash** terminal and type `java GumballMachineTestDrive santafe.mightygumball.com 100`
    
        GumballMachineTestDrive Ready

5. Open another **cmd** or **bash** terminal and type `java GumballMachineTestDrive boulder.mightygumball.com 100`
    
        GumballMachineTestDrive Ready

6. Open another **cmd** or **bash** terminal and type `java GumballMachineTestDrive seattle.mightygumball.com 250`

        GumballMachineTestDrive Ready

7. Open another **cmd** or **bash** terminal and type `java GumballMonitorTestDrive`
     
        GumbalMonitor.GumballMonitor@192d3247
        GumbalMonitor.GumballMonitor@5891e32e
        GumbalMonitor.GumballMonitor@1d371b2d
        Gumball Machine: santafe.mightygumball.com
        Current inventory: 100 gumballs
        Current state: No Quarter


        Gumball Machine: boulder.mightygumball.com
        Current inventory: 100 gumballs
        Current state: No Quarter


        Gumball Machine: seattle.mightygumball.com
        Current inventory: 250 gumballs
        Current state: No Quarter`
