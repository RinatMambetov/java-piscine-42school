package ex00;

public class Program {


    public static void main(String[] args) {

        int number = 134553;
        byte result = 0;

        result += number % 10;
        number /= 10;
        result += number % 10;
        number /= 10;
        result += number % 10;
        number /= 10;
        result += number % 10;
        number /= 10;
        result += number % 10;
        number /= 10;
        result += number % 10;

        System.out.println(result);
    }
}
