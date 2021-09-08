To run the RMI demo, go and:

1. Open the terminal or bash in `destDir` and run `rmiregistry`
The window should not print anything, the process should be running.

2. Open another terminal in `destDir` and run `java RemoteMethodInvocationDemo/Server`
The window will print **Server ready**

3. Open 3rd terminal in `destDir` and run `java RemoteMethodInvocationDemo/MyRemoteClient`
The window will print **response: Server says, `Hey`**


Reference tutorial: https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html#startRegistry