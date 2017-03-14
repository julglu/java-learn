/*
 * Created by Юлия on 13.03.2017.
 */
import java.io.*;
import java.lang.Math;
public class Homework1 {
    public static void main(String[] args){


       //Задание 1
        int q=21, w=8;
        System.out.println(q+"/"+w+" = "+q/w+" и "+q%w+" в остатке");

        //Задание 2
        int a=23;
        int sum=a/10+a%10;
        System.out.println(sum);

        //Задание 3
        double n=2.58;
        int r=(int)Math.round(n);
        System.out.println(r);

        //Задание 4
        a=123;
        int b;
        sum=0;

        String s=Integer.toString(a);

        for(int i=1; i<=s.length(); i++)
        {
                b=a%10;
                sum+=b;
                a/=10;
        }

        System.out.println(sum);


        //Задание 5
        int x=27;

        //Вариант 1 (без использования сдвиговых опрераций
        if(x%2==0)
            System.out.println("true");
        else
            System.out.println("false");

        //Вариант 2 (c использованием сдвиговых опрераций
        if((x>>1)<<1==x)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
