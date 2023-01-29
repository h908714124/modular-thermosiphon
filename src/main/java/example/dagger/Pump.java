package example.dagger;

import jakarta.inject.Inject;

public interface Pump {

    @Inject
    static Pump create(CoffeeLogger logger, Heater heater) {
        return new Thermosiphon(logger, heater);
    }

    void pump();
}
