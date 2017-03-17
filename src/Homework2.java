/*
 * Created by Юлия on 15.03.2017.
 */

import java.util.Random;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        //Условные операторы
        //1 Проверка на четность
        int n = 4;
        String s = n % 2 == 0 ? "Четное" : "Нечетное";
        System.out.println(s);

        //2 Вывести ближайшее к 10 число
        double a = 8.5, b = 11.45;
        double rez = Math.abs(a - 10) <= Math.abs(b - 10) ? a : b;
        System.out.println(rez);

        //3 Корни квадратного уравнения
        a = 3.5;
        b = 4;
        double c = 1;
        double desc = Math.pow(b, 2) - 4 * a * c;
        String s2 = desc >= 0 ? "x1=" + ((-b + Math.sqrt(desc)) / (2 * a)) + " x2=" + ((-b - Math.sqrt(desc)) / (2 * a)) : "Нет решения";
        System.out.println(s2);


        //Ветвление в программе
        //1 Попадает ли случайное число в интервал (25, 100)
        int x = (int) (Math.random() * 150) + 5;
        if (x > 25 && x < 100)
            System.out.println("Число " + x +
                    " содержится в интервале (25, 100)");
        else
            System.out.println("Число " + x +
                    " не содержится в интервале (25, 100)");

        //2 Вывод на экран случайно сгенерированного трехзначного числа и его наибольшей цифры
        int y = (int) (Math.random() * 1000);
        int y1 = y % 10, y2 = y % 100 / 10, y3 = y / 100;
        int max;
        if (y3 > y2)
            if (y3 > y1)
                max = y3;
            else
                max = y1;
        else if (y2 > y1)
            max = y2;
        else
            max = y1;
        System.out.println("В числе " + y + " наибольшая цифра " + max);

        //3 Вывод строго возрастающей последовательности
        Ex2_3();

        //Количество часов до окончания рабочего дня
        Ex2_4();

        //Циклы в Java
        Cycle_1();
        System.out.println();
        Cycle_2();
        System.out.println();
        Cycle_3();
        System.out.println();
        Cycle_4();
        System.out.println();
        System.out.println("Введите число, факториал которого надо вычислить:");
        Cycle_5();
        System.out.println();
        System.out.println("Введите число, для которого надо вывести все положительные делители:");
        Cycle_6();
        System.out.println();
        System.out.println("Введите натуральное число для проверки:");
        Cycle_7();
        System.out.println("Последовательность Фибоначчи:");
        Cycle_8();
        System.out.println();
        System.out.println("Введите число,сумму цифр которого нужно вычислить:");
        Cycle_9();
        System.out.println();
        Cycle_10();
        System.out.println();
        Cycle_11();
        System.out.println();
        Cycle_12();
        System.out.println();
        Cycle_13();

    }

    private static void Ex2_3() {
        int a = 7, b = 0, c = -5;
        System.out.println("Числа в переменных a, b, c: " + a + " " + b + " " + c);
        int tmp;
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (b > c) {
            tmp = b;
            b = c;
            c = tmp;
        }
        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        System.out.println("Возрастающая последовательность: " + a + " " + b + " " + c);
    }

    //Количество часов до окончания рабочего дня
    private static void Ex2_4() {
        //int sek = (int) (Math.random() * 28800);
        Random rnd = new Random();
        int sek = rnd.nextInt(28801);
        int hours = sek / 3600;
        if (hours == 0)
            System.out.println("Осталось меньше часа");
        else if (hours == 1)
            System.out.println("Остался 1 час");
        else if (hours < 5)
            System.out.println("Осталось " + hours + " часа");
        else
            System.out.println("Осталось " + hours + " часов");
    }

    //Вывод наэкран всех четырехзначных чисел послеовательности 1000 1003 1006 1009 1012 1015 ...
    private static void Cycle_1() {
        for (int i = 1000; i < 10000; i += 3) {
            System.out.print(i + " ");
        }
    }

    //Вывод на экран первых 55 элементов последовательности 1 3 5 7 9 ...
    private static void Cycle_2() {
        for (int i = 0; i < 55; i++) {
            System.out.print(i * 2 + 1 + " ");
        }
    }

    //Вывод на экран всех неотрицательных элментов последовательности 90 85 80 75 ...
    private static void Cycle_3() {
        int x = 95;
        while (x - 5 >= 0) {
            x -= 5;
            System.out.print(x + " ");
        }
    }

    //Вывод на экран первых 20 элементов последовательности 2 4 8 16 32 ...
    private static void Cycle_4() {
        for (int i = 1; i <= 20; i++) {
            System.out.print((int) Math.pow(2, i) + " ");
        }
    }

    //Вычисление факториала
    private static void Cycle_5() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }

    //Вывод на экран всех положительных делителей натурального числа
    private static void Cycle_6() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
        }
    }

    //Является ли число простым
    private static void Cycle_7() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("Число не простое");
        else
            System.out.println("Число простое");
    }

    //последовательность Фибоначчи
    private static void Cycle_8() {
        int seq = 1, prevSeq = 0, tmp;
        for (int i = 0; i < 11; i++) {
            System.out.print(seq + " ");
            tmp = seq;
            seq += prevSeq;
            prevSeq = tmp;
        }
    }

    //Вычисление суммы цифр в числе
    private static int DigitSum(int n) {
        int sum = 0;
        int l = Integer.toString(n).length();
        for (int i = 0; i < l; i++) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    //Сумма цифр в числе
    private static void Cycle_9() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Сумма цифр числа " + n + " равна " + DigitSum(n));
    }

    //Счастливый билет
    private static void Cycle_10() {
        int cnt = 0;
        for (int i = 1; i < 1000000; i++) {
            if (DigitSum(i / 1000) == DigitSum(i % 1000))
                cnt++;
        }
        System.out.println("Количество счастливых билетов: " + cnt);
    }

    //Бракованные таблички
    private static void Cycle_11() {
        int cnt = 0;
        for (int i = 1; i <= 50000; i++) {
            if (Integer.toString(i).contains("2"))
                cnt++;
        }
        System.out.println("Количество бракованных табличек: " + cnt);
    }

    //Симметричное время
    private static void Cycle_12() {
        int cnt = 0;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                if (i / 10 == j % 10 && i % 10 == j / 10)
                    cnt++;
            }
        }
        System.out.println("Количество симметричных комбинаций: " + cnt);
    }

    //Несчастливые номера
    private static void Cycle_13() {
        int cnt = 0;
        for (int i = 1; i < 100000; i++) {
            if (Integer.toString(i).contains("4") || Integer.toString(i).contains("13"))
                cnt++;
        }
        System.out.println("Исключить следует " + cnt + " номеров");

    }
}



