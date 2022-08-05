package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private final AnnotationConfigApplicationContext context;
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        serverSocket = new ServerSocket(port);
    }

    public void run() throws IOException {

        UserService userService = context.getBean("userService", UserService.class);

        Socket clientSocket;

        clientSocket = serverSocket.accept();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String username = "";
        String password = "";

        writer.write("Hello from server!\n");
        writer.flush();
        for (int i = 0; i < 3; i++) {
            String s = reader.readLine();

            if (i == 0 && s.equals("signUp")) {
                writer.write("Enter username:\n");
                writer.flush();
            }
            else if (i == 1) {
                username = s;
                writer.write("Enter password:\n");
                writer.flush();
            }
            else if (i == 2) {
                password = s;
                writer.write("Successful!\n");
                writer.flush();
            }
            else {
                writer.write("close\n");
                writer.flush();
                break;
            }
        }

        userService.signUp(username, password);

        if (!clientSocket.isClosed())
            clientSocket.close();
        serverSocket.close();
        context.close();
    }
}