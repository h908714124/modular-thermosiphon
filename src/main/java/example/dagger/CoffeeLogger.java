package example.dagger;

import jakarta.inject.Inject;

public final class CoffeeLogger {

    private final String level;

    @Inject
    CoffeeLogger(String level) {
        this.level = level;
    }

    public void log(String msg) {
        System.out.println(level + " " + msg);
    }
}
