package design_pattern.factory;

/**
 * Created by balas on 9/8/17.
 */
public class PizzaFactory {
    public static Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        } else {
            pizza = new CheesePizza();
        }
        return pizza;
    }
}
