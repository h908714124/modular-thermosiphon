package example.dagger;

class Thermosiphon implements Pump {
    private final CoffeeLogger logger;
    private final Heater heater;

    Thermosiphon(CoffeeLogger logger, Heater heater) {
        this.logger = logger;
        this.heater = heater;
    }

    @Override
    public void pump() {
        if (heater.isHot()) {
            logger.log("=> => pumping => =>");
        }
    }
}
