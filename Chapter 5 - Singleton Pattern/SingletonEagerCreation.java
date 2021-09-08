import org.graalvm.compiler.nodes.memory.MemoryCheckpoint.Single;

public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    private Singleton() {};

    public static synchronized Singleton getInstance(){
        return uniqueInstance;
    }

    // other code here ...
}
