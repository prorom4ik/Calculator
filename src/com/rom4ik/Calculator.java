package com.rom4ik;

import java.io.PrintWriter;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        intro();

        while (true) {

            System.out.print("Ввод: ");
            String expression = "";

            try {
                expression = scanner.nextLine(); // Считываем выражение, которое нужно посчитать
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            if (expression.equals("exit"))
                break;

            try {
                String[] strings = expression.split(" ");
                if (strings.length < 3) throw new Exception("Строка не является математической операцией");
                if (strings.length > 3) throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

                Number firstNumber = NumberService.parseAndValidate(strings[0]);
                Number secondNumber = NumberService.parseAndValidate(strings[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, strings[1]);
                System.out.println("Ответ: " + result);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                break;
            }
        }
    }

    private static void intro()  {
        System.out.println("Данный калькулятор работает только с арабскими и римскими цифрами от 1 до 10.");
        System.out.println("Выражение для вычислений вводите, разделяя операнды и оператор символов пробела");
        System.out.println("Доступные операции: +, -, *, /");
        System.out.println("Для выхода введите 'exit'");
    }
}
