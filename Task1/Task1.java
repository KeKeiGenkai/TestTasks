package Task1;

import  java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Длинна массива: ");
        int n = readInt(scanner);

        System.out.print("Длинна шага: ");
        int m = readInt(scanner);

        int[] circularArray = new int[n];
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int[] path = findCircularArrayPath(circularArray, m);

        for (int i : path) {
            System.out.print(i);
        }
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static int[] findCircularArrayPath(int[] circularArray, int m) {
        int[] path = new int[circularArray.length];
        int currentIndex = 0;

        for (int i = 0; i < circularArray.length; i++) {
            int currentNumber = circularArray[currentIndex];

            path[i] = currentNumber;

            int nextIndex = (currentIndex + m - 1) % circularArray.length;
            circularArray[currentIndex] = 0;
            currentIndex = nextIndex;
        }

        int nonZeroCount = 0;
        for (int i : path) {
            if (i != 0) {
                nonZeroCount++;
            }
        }
        int[] result = new int[nonZeroCount];
        for (int i = 0, j = 0; i < path.length; i++) {
            if (path[i] != 0) {
                result[j++] = path[i];
            }
        }

        return result;
    }
}