package Day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int value = 0;
        List<String> input = getInput();
        List<Integer> numbers = new ArrayList<>();
        for (String s: input) {
            numbers.add(getNumbers(s));
        }
        System.out.println(countEmUp(numbers));
    }

    public static List<String> getInput() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream("input.txt");
        Scanner scan = new Scanner(fis);
        while (scan.hasNext()) {
            list.add(scan.nextLine());
        }
        scan.close();
        return list;
    }

    public static int getNumbers(String input) {
        String firstNumber = "";
        String secondNumber = "";
        String finalNumber;

        boolean firstNumberFound = false;
        boolean secondNumberFound = false;
        for (int i = 0; i < input.length(); i++) {
            String s = "";
            if (firstNumberFound && secondNumberFound) {
                break;
            }
            s = input.substring(i, i + 1);
            if (isNumber(s) && !firstNumberFound) {
                firstNumber = s;
                firstNumberFound = true;
            }
            s = input.substring(input.length() - i - 1, input.length() - i);
            if (isNumber(s) && !secondNumberFound) {
                secondNumber = s;
                secondNumberFound = true;
            }
        }
        finalNumber = firstNumber + secondNumber;
        return Integer.parseInt(finalNumber);
    }

    public static boolean isNumber(String characterToCheck) {
        try{
            int number = Integer.parseInt(characterToCheck);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }

    }

    public static long countEmUp(List<Integer> numbers) {
         return numbers.stream().mapToInt(n -> n).sum();
    }
}