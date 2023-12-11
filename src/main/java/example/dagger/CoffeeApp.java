package example.dagger;

import io.jbock.simple.Component;

public class CoffeeApp {

    @Component(mockBuilder = true)
    public interface CoffeeShop {
        CoffeeMaker maker();

        @Component.Builder
        interface Builder {
            Builder logLevel(String logLevel);

            CoffeeShop build();
        }
    }

    public static void main(String[] args) {
        String logLevel = "INFO";
        CoffeeShop coffeeShop = CoffeeApp_CoffeeShop_Impl.builder().logLevel(logLevel).build();
        coffeeShop.maker().brew();
    }
}
