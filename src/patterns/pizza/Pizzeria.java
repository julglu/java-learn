package patterns.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юлия on 20.04.2017.
 */
public class Pizzeria {
    public static void main(String[] args) {
        List<Component> margheritaTopping=new ArrayList<>();
        margheritaTopping.add(Component.TOMATOES);
        Pizza margherita=new Pizza
                .Builder(Dough.SOLID,Cheese.MOZZARELLA,Sauce.LITE)
                .topping(margheritaTopping)
                .addComponent();
        System.out.println("Pizza Margherita:\n"+margherita);
    }
}
