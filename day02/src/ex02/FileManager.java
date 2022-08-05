package ex02;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Error: wrong amount of arguments");
            System.exit(-1);
        }

        Path startPath = Paths.get(args[0].substring("--current-folder=".length()));
        Commands commands = new Commands(startPath);

        Scanner scan = new Scanner(System.in);
        String line;
        do {
            System.out.print("-> ");
            line = scan.nextLine();
            String[] cmd = line.split(" ");
            switch (cmd[0]) {
                case "ls":
                    commands.ls();
                    break;
                case "cd":
                    commands.cd(Paths.get(cmd[1]));
                    break;
                case "mv":
                    commands.mv(Paths.get(cmd[1]), Paths.get(cmd[2]));
                    break;
                case "exit":
                    scan.close();
                    System.exit(0);
                default:
                    System.out.println("Error: " + cmd[0] + " cmd not found. Type \"exit\" to quit the program");
            }
        } while (true) ;
    }
}
