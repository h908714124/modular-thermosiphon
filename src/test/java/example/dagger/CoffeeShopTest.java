package example.dagger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CoffeeShopTest {

    @Test
    void integrationTest() {
        boolean[] invoked = {false};
        CoffeeLogger mockCoffeeLogger = new CoffeeLogger("OUCH") {
            @Override
            public void log(String msg) {
                invoked[0] = true;
            }
        };
        CoffeeApp.CoffeeShop app = CoffeeApp_CoffeeShop_Impl.mockBuilder().coffeeLogger(mockCoffeeLogger)
                .build()
                .create("INFO");
        app.maker().brew();
        assertTrue(invoked[0]);
    }
}