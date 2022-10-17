
import java.util.Scanner;

import static java.lang.Integer.*;

public class CalcString {
    static String input;
    static String num1;
    static String num2;
    static String Output;


    public static void main(String[] args) throws Exception {

    Scanner in = new Scanner(System.in);
    input = in.nextLine();
    String[] token = input.split("[+-/*]");
            if (input.isBlank()) {
        throw new Exception("Введите выражение");
    } else if (token.length != 2) {
        throw new Exception("Формат не удовлетворяет заданию");
    }
    num1 = token[0];
    num2 = token[1];
    num1 = num1.trim();
    num2 = num2.trim();

            if (num1.length() > 12 || num2.length() > 12) {
        throw new Exception("Калькулятор принимает строки длинной не более 10 символов");
    }else if (argument(num1) == false){throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка");}

            if (input.contains("+")) {
        num1 = num1.replaceAll("\"", "");
        num2 = num2.replaceAll("\"", "");
        Output = num1 + num2;
    } else if (input.contains("-")) {
        num1 = num1.replaceAll("\"", "");
        num2 = num2.replaceAll("\"", "");
        Output = num1.replace(num2, "");
    } else if (input.contains("*")) {
        Output = Ymnog.tup(num1, num2);
    } else if (input.contains("/")) {
        Output = Razdeli.rut(num1, num2);
    }else {throw new Exception("Некорректный знак действия (+, -, /, *)");}
            System.out.println("\"" + Output + "\"");
}

    static boolean argument(String num1){
        try {Integer.parseInt(num1);
            return false;
        }catch (NumberFormatException e){return true;}
    }

}


class Ymnog {
    static String result;
    static String tup(String num1, String num2) throws Exception {

        num1 = num1.replaceAll("\"", "");

        String Arab = "1,2,3,4,5,6,7,8,9,10";

        if (Arab.contains(num2)) //throw new Exception("Строчку можно делить или умножать только на число");
        {
            int num = parseInt(num2);
            result = "";
            for (int i = 0; i < num; i++) {
                result += num1;
            }
        }else { throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");}

        return result;
    }
}


class Razdeli {
    static String result;
    static String rut(String num1, String num2) throws Exception {

        num1 = num1.replaceAll("\"", "");

        String Arab = "1,2,3,4,5,6,7,8,9,10";
        if (Arab.contains(num2)) {
            int num = parseInt(num2);
            int newLen = num1.length() / num;
            result = num1.substring(0, newLen);
        }else { throw new Exception("Строчку можно делить или умножать только на число от 1 до 10 включительно, не более.");}
        return result;
    }
}
