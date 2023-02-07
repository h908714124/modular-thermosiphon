package example.dagger;

import jakarta.inject.Inject;
import jakarta.inject.Provider;

public class CoffeeMaker {

    private final CoffeeLogger logger;
    private final Heater heater;
    private final Pump pump;

    @Inject
    CoffeeMaker(CoffeeLogger logger, Heater heater, Provider<Pump> pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump.get();
    }

    public void brew() {
        heater.on();
        pump.pump();
        logger.log(" [_]P coffee! [_]P ");
        heater.off();
    }
}
