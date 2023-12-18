package example.dagger;

import io.jbock.simple.Component;
import jakarta.inject.Inject;

class CoffeeApp {

    @Component(mockBuilder = true)
    interface CoffeeComponent {
        CoffeeMaker coffeeMaker();

        @Component.Builder
        interface Builder {
            Builder logLevel(String logLevel);

            CoffeeComponent buildComponent();
        }
    }

    interface Logger {
        void log(String msg);
    }

    static class CoffeeMaker {
        private final Logger logger;

        @Inject
        CoffeeMaker(Logger logger) {
            this.logger = logger;
        }

        void brew() {
            logger.log("~ ~ ~ heating ~ ~ ~");
            logger.log("=> => pumping => =>");
            logger.log(" [_]P coffee! [_]P ");
        }
    }

    @Inject
    static Logger createLogger(String level) {
        return msg -> System.out.println(level + " " + msg);
    }
}
