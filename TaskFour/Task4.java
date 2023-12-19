package TaskFour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = scanner.nextLine();

        int[] array = readArrayFromFile(filePath);
        int moves = equalizeArray(array);

        System.out.println(moves);

        scanner.close();
    }

    public static int[] readArrayFromFile(String filePath) {
        int[] array = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int size = 0;
            while (reader.readLine() != null) {
                size++;
            }

            array = new int[size];

            BufferedReader newReader = new BufferedReader(new FileReader(filePath));

            for (int i = 0; i < size; i++) {
                String line = newReader.readLine().trim();
                array[i] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }

    public static int equalizeArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;

        int moves = 0;
        for (int i = 0; i < array.length; i++) {
            while (array[i] < average) {
                array[i]++;
                moves++;
            }
            while (array[i] > average) {
                array[i]--;
                moves++;
            }
        }

        return moves;
    }
}