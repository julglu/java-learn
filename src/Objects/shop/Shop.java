package Objects.shop;

import Objects.arrayList.ArrayList;
import Objects.interfaces.List;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/*
 * Created by Юлия on 31.03.2017.
 */
public class Shop {
    private static int startUserID = 0;
    private static List stock;
    private static List cart;
    private static int userNextId;
    private static double balance=0;

    public static void main(String[] args) {
        //Создать базу товаров
        Product p1 = new Product("plate", 100, 10);
        Product p2 = new Product("spoon", 80, 10);
        Product p3 = new Product("knife", 70, 10);
        stock = new ArrayList();
        cart = new ArrayList();
        stock.add(p1);
        stock.add(p2);
        stock.add(p3);

        while (true) {

            System.out.println("Здравствуйте, новый покупатель");
            userNextId = generateUserID();
            System.out.println("Ваш ID: " + userNextId + "\n");

            //Вывести  список товаров, имеющихся  в наличии
            System.out.println("ID\tName\tprice\tquantity");
            for (Object p : stock) {
                if (((Product) p).qnt > 0)
                    System.out.println(p.toString());
            }

            List order = new ArrayList();
            int totalSum = 0;
            Scanner s = new Scanner(System.in);
            String str;
            exitpoint:
            while (true) {
                System.out.println("Введите команду для покупки товаров:");
                System.out.println("add id quantity");
                str = s.nextLine();
                if (str.matches("add \\d+ \\d+")) {
                    int prodID = Integer.parseInt(str.substring(4, str.lastIndexOf(" ")));
                    int orderQnt = Integer.parseInt(str.substring(str.lastIndexOf(" ") + 1));
                    for (Object p : stock) {
                        if (((Product) p).productID == prodID) {
                            if (((Product) p).qnt >= orderQnt) {
                                Product orderItem = new Product(((Product) p).productName, ((Product) p).price, orderQnt);
                                order.add(orderItem);
                                ((Product) p).qnt -= orderQnt;
                                totalSum += ((Product) p).price * orderQnt;
                                System.out.println("Если Вы хотите продолжить покупку, введите continue,\n" +
                                        "Если Вы хотите перейти к оплате заказа введите quit");
                                str = s.nextLine();
                                if (str.equals("continue"))
                                    break;
                                if (str.equals("quit"))
                                    break exitpoint;
                            }
                            System.out.println("К сожалению, количество товара на складе меньше запрашиваемого");
                            break;
                        }
                    }
                }
            }
            Transaction t;
            System.out.println("Ваш заказ:");
            System.out.println("productName\tprice\tqnt");
            for (Object p : order) {
                System.out.println(((Product) p).productName + "\t" + ((Product) p).price + "\t" + ((Product) p).qnt);
            }
            while (true) {
                System.out.println("Введите требуемую сумму (" + totalSum + ") при помощи команды buy сумма:");
                str = s.nextLine();
                if (str.matches("buy \\d+")) {
                    double sum=Double.parseDouble(str.substring(str.lastIndexOf(" ") + 1));
                    if (sum >= totalSum) {
                        if (sum > totalSum)
                            System.out.println("Ваша сдача: " + (sum - totalSum));
                        t = new Transaction(order, userNextId, totalSum);
                        balance+=totalSum;
                        System.out.println(t.toString());
                        break;
                    }
                    System.out.println("Введенная сумма меньше запашиваемой");
                }

            }
            cart.add(t);
            System.out.println("Если хотите продолжить работу с приложением введите cotinue,\n" +
                    "Если хотите закончить работу с приложением введите exit");
            if (s.next().equals("exit"))
                break;

        }
        System.out.println("Список продаж:");
        for (Object t : cart) {
            System.out.println(t.toString());
        }
    }

    private static int generateUserID() {
        if (startUserID == 0) {
            Random rnd = new Random();
            startUserID = rnd.nextInt(100000);
            userNextId=startUserID;
        }
        return userNextId++;
    }



    public static class Product {
        static int startId=0;
        int productID;
        String productName;
        double price;
        int qnt;

        public Product (String name, double price, int qnt){
            if(startId==0){
                Random rnd=new Random();
                startId=rnd.nextInt(100000);
            }
            productID=startId++;
            productName=name;
            this.price=price;
            this.qnt=qnt;
        }

        @Override
        public String toString() {
            return productID+"\t"+productName+"\t"+price+"\t"+qnt;
        }
    }




    public static class Transaction {
        static int startTrID=0;
        private int transactionID;
        private Date date;
        private List products;
        private int userID;
        private int total;

        public Transaction(List l, int userID, int total){
            if(startTrID==0){
                Random rnd=new Random();
                startTrID=rnd.nextInt(100000);
            }
            transactionID=startTrID++;
            date=new Date();
            products=l;
            this.userID=userID;
            this.total=total;

        }

        @Override
        public String toString() {
            String rez;
            StringBuilder sb=new StringBuilder();
            sb.append(transactionID+"\t"+date+"\t"+userID+"\t");
            for(Object p:products){
                sb.append(((Product)p).productName+", ");
            }
            sb.delete(sb.length()-2,sb.length());
            sb.append("\t"+total);
            return sb.toString();
        }
    }
}
