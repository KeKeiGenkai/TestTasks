package Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Путь к файлу с координатами и радиусом окружности: ");
        String pathToFile1 = scanner.nextLine();

        System.out.print("Путь к файлу с координатами точек: ");
        String pathToFile2 = scanner.nextLine();

        scanner.close();

        double centerX = 0.0;
        double centerY = 0.0;
        double radius = 0.0;

        try {
            Scanner file1Scanner = new Scanner(new File(pathToFile1));
            centerX = file1Scanner.nextDouble();
            centerY = file1Scanner.nextDouble();
            radius = file1Scanner.nextDouble();
            file1Scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла с координатами окружности: " + e.getMessage());
            return;
        }

        try {
            Scanner file2Scanner = new Scanner(new File(pathToFile2));

            while (file2Scanner.hasNext()) {
                double x = 0.0;
                double y = 0.0;

                if (file2Scanner.hasNextDouble()) {
                    x = file2Scanner.nextDouble();
                } else {
                    System.out.println("Ошибка чтения координаты x из файла с координатами точек.");
                    return;
                }

                if (file2Scanner.hasNextDouble()) {
                    y = file2Scanner.nextDouble();
                } else {
                    System.out.println("Ошибка чтения координаты y из файла с координатами точек.");
                    return;
                }

                int position = getPositionRelativeToCircle(x, y, centerX, centerY, radius);

                switch (position) {
                    case 0 -> System.out.println(" 0 - точка лежит на окружности");
                    case 1 -> System.out.println(" 1 - точка внутри окружности");
                    case 2 -> System.out.println(" 2 - точка снаружи окружности");
                    default -> System.out.println("Неизвестное положение точки");
                }
            }

            file2Scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла с координатами точек: " + e.getMessage());
        }
    }

    private static int getPositionRelativeToCircle(double x, double y, double centerX, double centerY, double radius) {
        double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

        if (Math.abs(distance - radius) < 1e-6) {
            return 0;
        } else if (distance < radius) {
            return 1;
        } else {
            return 2;
        }
    }
}