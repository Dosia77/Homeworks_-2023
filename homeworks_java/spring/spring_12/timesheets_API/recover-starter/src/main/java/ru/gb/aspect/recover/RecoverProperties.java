package ru.gb.aspect.recover;

import org.apache.logging.log4j.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application.recover")
public class RecoverProperties {

    private Level level = Level.ERROR;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
