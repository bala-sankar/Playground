package Factory;

/**
 * Created by balas on 9/8/17.
 */
public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = PizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
