package example.dagger;

class ElectricHeater implements Heater {

    private final CoffeeLogger logger;
    private boolean heating;

    ElectricHeater(CoffeeLogger logger) {
        this.logger = logger;
    }

    @Override
    public void on() {
        this.heating = true;
        logger.log("~ ~ ~ heating ~ ~ ~");
    }

    @Override
    public void off() {
        this.heating = false;
    }

    @Override
    public boolean isHot() {
        return heating;
    }
}
