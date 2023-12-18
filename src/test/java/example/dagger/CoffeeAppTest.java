package example.dagger;

import example.dagger.CoffeeApp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CoffeeAppTest {

    @Test
    void testWithMockLogger() {
        List<String> messages = new ArrayList<>();
        CoffeeApp.Logger mockLogger = messages::add;
        CoffeeApp.CoffeeComponent app = CoffeeApp_CoffeeComponent_Impl.builder()
                .logLevel("")
                .withMocks()
                .coffeeAppLogger(mockLogger)
                .build();
        app.coffeeMaker().brew();
        assertEquals(List.of(
                        "~ ~ ~ heating ~ ~ ~",
                        "=> => pumping => =>",
                        " [_]P coffee! [_]P "),
                messages);
    }
}