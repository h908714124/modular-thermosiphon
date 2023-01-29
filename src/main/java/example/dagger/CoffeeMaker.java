package example.dagger;

import jakarta.inject.Inject;

public class CoffeeMaker {

    private final CoffeeLogger logger;
    private final Heater heater;
    private final Pump pump;

    @Inject
    CoffeeMaker(CoffeeLogger logger, Heater heater, Pump pump) {
        this.logger = logger;
        this.heater = heater;
        this.pump = pump;
    }

    public void brew() {
        heater.on();
        pump.pump();
        logger.log(" [_]P coffee! [_]P ");
        heater.off();
    }
}
