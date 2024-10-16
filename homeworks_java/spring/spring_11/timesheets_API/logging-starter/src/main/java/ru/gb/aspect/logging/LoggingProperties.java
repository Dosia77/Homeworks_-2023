package ru.gb.aspect.logging;

import lombok.Data;
//import org.slf4j.event.Level;
import org.apache.logging.log4j.Level;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@Data
@ConfigurationProperties("application.logging")
public class LoggingProperties {

  private Level level = Level.DEBUG;

  public Level getLevel() {
    return level;
  }

  public void setLevel(Level level) {
    this.level = level;
  }
//  public boolean isPrintArgs() {
//    return printArgs;
//  }

  public boolean isPrintArgs() {
    return printArgs;
  }

  public void setPrintArgs(boolean printArgs) {
    this.printArgs = printArgs;
  }

  private boolean printArgs = false;

  // enum, string, (int, long), boolean,
  // List<...>
  // Map<..., ...>
  // Map<String, List<String>> mapping;
  // Any class

//  private Output output;
//
//  @Data
//  public static class Output {
//    private String type;
//    private Level level;
//    private boolean enabled = true;
//  }

}
