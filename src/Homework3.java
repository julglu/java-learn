import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Created by Юлия on 17.03.2017.
 */
public class Homework3 {
    public static void main(String[] args) {
        arrTask1();
        arrTask2();
        arrTask3();
        arrTask4();
        arrTask5();
        arrTask6();
        arrTask7();
        arrTask8();
        arrTask9();
        arrTask10();
        arrTask11();
        arrTask12();
        arrTask13();
        arrMultiDim1();
        arrMultiDim2();
        arrMultiDim3();
        arrMultiDim4();
        arrMultiDim5();

    }

    //Вывод массива четных чисел от 2 до 20
    private static void arrTask1() {
        int[] arr = new int[10];
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = i * 2;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //Вывод массива нечетных чисел от 1 до 99 и от 99 до 1
    private static void arrTask2() {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2 + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    //Количество четных элементов в массиве случайных чисел
    private static void arrTask3() {
        int[] arr = new int[15];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {

            arr[i] = rnd.nextInt(10);
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] % 2 == 0)
                cnt++;
        }
        System.out.println();
        System.out.println("В массиве " + cnt + " четных элементов");

    }

    //Замена элементов с нечетным индексом на 0
    private static void arrTask4() {
        int[] arr = new int[8];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10) + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = 0;
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //Сравнение средних арифметических двух массивов
    private static void arrTask5() {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        Random rnd = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(6);
            arr2[i] = rnd.nextInt(6);
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int avg1 = 0, avg2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            avg1 += arr1[i];
            avg2 += arr2[i];
        }
        avg1 /= arr1.length;
        avg2 /= arr2.length;

        if (avg1 > avg2)
            System.out.println("Среднее арифметическое элементов первого массива больше");
        else if (avg2 > avg1)
            System.out.println("Среднее арифметическое элементов второго массива больше");
        else
            System.out.println("Средние арифметические элементов обоих массивов равны");
    }

    //Является ли массив строго возрастающей последовательностью
    private static void arrTask6() {
        Random rnd = new Random();
        int[] arr = new int[4];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(90) + 10;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("Последовательность не является строго возрастающей");
        else
            System.out.println("Последовательность является строго возрастающей");
    }

    //Массив из членов последовательности Фибоначчи
    private static void arrTask7() {
        int[] arr = new int[20];
        int seq = 1, prevSeq = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = seq;
            seq += prevSeq;
            prevSeq = arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    //Индекс максимального элемента массива
    private static void arrTask8() {
        int arr[] = new int[12];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(31) - 15;
        }
        System.out.println(Arrays.toString(arr));
        int max = arr[0], maxIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Максимальный элемент в массиве: " + max + " с индексом " + maxIndex);
    }

    //Вывод количества целых элементов в массиве
    private static void arrTask9() {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        double[] arr3 = new double[10];
        Random rnd = new Random();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rnd.nextInt(9) + 1;
            arr2[i] = rnd.nextInt(9) + 1;
            arr3[i] = (double) arr1[i] / (double) arr2[i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        int cnt = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] * 10 % 10 == 0)
                cnt++;
        }
        System.out.println("В третьем массиве " + cnt + " целых элементов");
    }

    //Какой элемент встречается чаще всего -1, 0 или 1
    private static void arrTask10() {
        int[] arr = new int[11];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(3) - 1;
        }
        System.out.println(Arrays.toString(arr));
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case -1:
                    a++;
                    break;
                case 0:
                    b++;
                    break;
                case 1:
                    c++;
                    break;
            }
        }
        if (a > b && a > c)
            System.out.println("-1");
        else if (b > a && b > c)
            System.out.println("0");
        else if (c > a && c > b)
            System.out.println("1");
    }

    //Сравнение сумм модулей элементов двух половин массива
    private static void arrTask11() {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int n;
        while (true) {
            System.out.println("Введите четное положительное число");
            n = in.nextInt();
            if (n % 2 == 0 && n > 0)
                break;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(11) - 5;
        }
        System.out.println(Arrays.toString(arr));
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < n / 2; i++) {
            sumLeft += Math.abs(arr[i]);
            sumRight += Math.abs(arr[n - i - 1]);
        }
        if (sumLeft > sumRight)
            System.out.println("Сумма модулей элементов левой половины массива больше");
        else if (sumRight > sumLeft)
            System.out.println("Сумма модулей элементов правой половины массива больше");
        else
            System.out.println("Сумма модулей элементов левой и правой половин массива равны");
    }

    //Массив с одинаковым количеством отрицательных и положительных элементов
    private static void arrTask12() {
        int[] arr = new int[12];
        Random rnd = new Random();
        int cntPlus = 0, cntMinus = 0;
        for (int i = 0; i < arr.length; i++) {
            int x;
            while (true) {
                x = rnd.nextInt(21) - 10;
                if (x != 0)
                    break;
            }
            if (x > 0)
                cntPlus++;
            else
                cntMinus++;
            if (cntMinus <= arr.length / 2)
                if (cntPlus <= arr.length / 2)
                    arr[i] = x;
                else {
                    arr[i] = -x;
                    cntPlus--;
                    cntMinus++;
                }
            else {
                arr[i] = -x;
                cntPlus++;
                cntMinus--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Вывод массива из n элементов и массива из его четных элементов
    private static void arrTask13() {
        Scanner s = new Scanner(System.in);
        Random rnd = new Random();
        int n;
        while (true) {
            System.out.println("Введите натуральное число больше 3");
            n = s.nextInt();
            if (n > 3)
                break;
        }
        int[] arr = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(n + 1);
            if (arr[i] % 2 == 0)
                cnt++;
        }
        System.out.println(Arrays.toString(arr));
        if (cnt > 0) {
            int[] evenArr = new int[cnt];
            int j = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 == 0) {
                    evenArr[j] = arr[i];
                    j++;
                }
            }
            System.out.println(Arrays.toString(evenArr));
        } else
            System.out.println("Четных элементов нет");
    }

    //Многомерные массивы
    //Двумерный массив 8х5 из случайных чисел
    private static void arrMultiDim1() {
        Random rnd = new Random();
        int[][] arr = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = rnd.nextInt(90) + 10;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Вывод двумерного массива и его максимального элемента
    private static void arrMultiDim2() {
        Random rnd = new Random();
        int[][] arr = new int[8][5];
        int max = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = rnd.nextInt(199) - 99;
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > max)
                    max = arr[i][j];
            }
            System.out.println();
        }
        System.out.println(max);
    }

    //Вывод двумерного массива и индекса строки с максимальным по модулю произведением элементов
    private static void arrMultiDim3() {
        Random rnd = new Random();
        int[][] arr = new int[7][4];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = rnd.nextInt(11) - 5;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        int maxMultiply = 1, curMultiply = 1, maxInd = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 4; j++) {
                curMultiply *= Math.abs(arr[i][j]);
            }
            if (curMultiply > maxMultiply) {
                maxInd = i;
                maxMultiply = curMultiply;
            }
            curMultiply = 1;
        }
        System.out.println(maxInd);
    }

    //Двумерный массив, где первые элементы в строке - максимальные элементы в строке
    private static void arrMultiDim4() {
        Random rnd = new Random();
        int[][] arr = new int[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                arr[i][j] = rnd.nextInt(10);
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        int tmp;
        for (int i = 0; i < 6; i++) {
            for (int j = 5; j >= 0; j--) {
                if (arr[i][j] < arr[i][j + 1]) {
                    tmp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //15 различных примеров из таблицы умножения
    private static void arrMultiDim5() {
        int[][] multiplyTable = new int[8][8];
        Random rnd = new Random();
        for (int k = 0; k < 15; k++) {
            while (true) {
                int i = rnd.nextInt(8) + 2;
                int j = rnd.nextInt(8) + 2;
                if (multiplyTable[i - 2][j - 2] == 0) {
                    System.out.println(i + "*" + j + "=");
                    multiplyTable[i - 2][j - 2] = 1;
                    multiplyTable[j - 2][i - 2] = 1;
                    break;
                }
            }
        }

    }
}








