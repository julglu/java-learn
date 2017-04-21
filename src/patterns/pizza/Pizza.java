package patterns.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юлия on 20.04.2017.
 */
public class Pizza {
    private final Dough dough;
    private final Cheese cheese;
    private final Sauce sauce;
    private final List<Component> components;

    public static class Builder{
        private final Dough dough;
        private final Cheese cheese;
        private final Sauce sauce;
        private List<Component> components=new ArrayList<>();
        public Builder(Dough d, Cheese c, Sauce s){
            dough=d;
            cheese=c;
            sauce=s;
        }
        public Builder topping(List<Component> components){
            this.components=components;
            return this;
        }

        public Pizza addComponent(){
            return new Pizza(this);
        }

    }
    public Pizza(Builder builder){
        dough=builder.dough;
        sauce=builder.sauce;
        cheese=builder.cheese;
        components=builder.components;
    }

    @Override
    public String toString() {
        return "Dough: "+dough+"\n"+
                "Sauce: " +sauce+"\n"+
                "Cheese: " +cheese+"\n"+
                "Topping:"+components;
    }
}
