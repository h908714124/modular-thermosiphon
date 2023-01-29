package example.dagger;

import jakarta.inject.Inject;

public interface Heater {

    @Inject
    static Heater getInstance(CoffeeLogger logger) {
        return new ElectricHeater(logger);
    }

    void on();

    void off();

    boolean isHot();
}
