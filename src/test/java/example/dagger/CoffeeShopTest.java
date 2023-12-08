package example.dagger;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoffeeShopTest {

    @Test
    void testWithMockLogger() {
        List<String> messages = new ArrayList<>();
        CoffeeLogger mockLogger = new CoffeeLogger("") {
            @Override
            public void log(String msg) {
                messages.add(msg);
            }
        };
        CoffeeApp.CoffeeShop app = CoffeeApp_CoffeeShop_Impl.mockBuilder()
                .coffeeLogger(mockLogger)
                .build()
                .create("");
        app.maker().brew();
        assertEquals(List.of(
                        "~ ~ ~ heating ~ ~ ~",
                        "=> => pumping => =>",
                        " [_]P coffee! [_]P "),
                messages);
    }
}