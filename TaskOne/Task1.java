package TaskOne;

import  java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        System.out.print("m = ");
        int m = scanner.nextInt();
        scanner.close();

        if (n <= 0 || m <= 0){
            System.out.println("Err");
            return;
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = i + 1 ;
        }

        int[] result = path(array, m);

        int lastVal = result[result.length - 1];
        for (int i = result.length - 1; i > 0; i--){
            result[i] = result[i - 1];
        }
        result[0] = lastVal;

        for (int value : result) {
            System.out.print(value);
        }
    }
    private static int[] path(int[] array, int m) {
        int[] result = new int[array.length];
        int index = 0;
        boolean[] visited = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            index = (index + (m - 1)) % array.length;

            while (visited[index]) {
                int[] trim = new int[i];
                System.arraycopy(result, 0, trim, 0, i);

                System.out.print("Result: ");
                for (int value : trim) {
                    System.out.print(value);
                }
                System.exit(0);
            }

            visited[index] = true;
            result[i] = array[index];
        }
        return result;
    }
}