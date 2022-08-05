package ex01.ImagesToChar.src.java.edu.school21.printer.app;

import ex01.ImagesToChar.src.java.edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Error: Wrong number of arguments");
            System.exit(-1);
        }
        char white = args[0].charAt(0);
        char black = args[1].charAt(0);

        int[][] array = Logic.getArray(black, white);

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                System.out.print((char) array[y][x]);
            }
            System.out.println();
        }
    }
}
