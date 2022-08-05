package ex01;

import java.io.*;
import java.util.*;

public class Words {

    private static List<String> inputA = new ArrayList<>();
    private static List<String> inputB = new ArrayList<>();
    private static final TreeSet<String> dictionary = new TreeSet<>();
    private static boolean isAEmpty = false;
    private static boolean isBEmpty = false;

    static List<String> fillDictionary(BufferedReader br) throws IOException {
        String line;
        List<String> input = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] arrayOfWords = line.split(" ");
            input.addAll(Arrays.asList(arrayOfWords));
            dictionary.addAll(input);
        }
        return (input);
    }

    static void getInputs(String fileA, String fileB) throws IOException {

        BufferedReader brA = new BufferedReader(new FileReader(fileA));
        BufferedReader brB = new BufferedReader(new FileReader(fileB));

        if (!brA.ready()) {
            isAEmpty = true;
            return ;
        }
        if (!brB.ready()) {
            isBEmpty = true;
            return ;
        }

        inputA = fillDictionary(brA);
        inputB = fillDictionary(brB);

        brA.close();
        brB.close();
    }

    static void fillVector(List<Integer> vector, List<String> input) {

        int i = 0;
        int count = 0;

        for (String dictElem : dictionary) {
            for (String inputElem : input) {
                if (dictElem.equals(inputElem))
                    count++;
            }
            vector.add(i, count);
            count = 0;
            i++;
        }
    }

    static int findNumerator(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < dictionary.size(); i++)
            sum += a.get(i) * b.get(i);
        return sum;
    }

    static double findDenominator(List<Integer> a, List<Integer> b) {
        double sumA = 0;
        for (Integer x : a)
            sumA += x * x;
        double sumB = 0;
        for (Integer x : b)
            sumB += x * x;
        return Math.sqrt(sumA) * Math.sqrt(sumB);
    }

    static double calculateSimilarity() {
        List<Integer> vectorA = new ArrayList<>(dictionary.size());
        List<Integer> vectorB = new ArrayList<>(dictionary.size());

        fillVector(vectorA, inputA);
        fillVector(vectorB, inputB);

        int numerator = findNumerator(vectorA, vectorB);
        double denominator = findDenominator(vectorA, vectorB);
        return (numerator / denominator);
    }

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Error: wrong amount of arguments");
            System.exit(-1);
        }
        getInputs(args[0], args[1]);
        if (isAEmpty && isBEmpty)
            System.out.println("Similarity = 1.00");
        else if (isAEmpty || isBEmpty)
            System.out.println("Similarity = 0.00");
        else {
            String str = String.format("%.3f", calculateSimilarity());
            System.out.println("Similarity = " + str.substring(0, str.length() - 1));
        }
    }
}
