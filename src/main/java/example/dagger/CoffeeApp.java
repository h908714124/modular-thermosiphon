package example.dagger;

import io.jbock.simple.Component;

public class CoffeeApp {

    @Component
    public interface CoffeeShop {
        CoffeeMaker maker();

        @Component.Factory
        interface Factory {
            CoffeeShop create(String logLevel);
        }
    }

    public static void main(String[] args) {
        String logLevel = "INFO";
        CoffeeShop coffeeShop = CoffeeApp_CoffeeShop_Impl.factory().create(logLevel);
        coffeeShop.maker().brew();
    }
}
