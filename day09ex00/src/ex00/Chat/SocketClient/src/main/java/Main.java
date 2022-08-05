import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

@Parameters(separators = "=")
public class Main {

    @Parameter(names = "--server-port")
    private Integer portConnectTo;

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        JCommander.newBuilder().addObject(main).build().parse(args);
        main.run();
    }

    private void run() throws IOException {
        Socket socket = new Socket("127.0.0.1", portConnectTo);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String s = reader.readLine();
            if (s.equals("close")) {
                closeConnections(socket, reader, writer);
                System.exit(-1);
            }
            System.out.println(s);
            System.out.print("> ");
            writer.write(scanner.nextLine() + '\n');
            writer.flush();
        }
        System.out.println(reader.readLine());

        closeConnections(socket, reader, writer);
    }

    private void closeConnections(Socket socket, BufferedReader reader, BufferedWriter writer) throws IOException {
        socket.close();
        writer.close();
        reader.close();
    }
}