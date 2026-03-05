package org.example.config;

import java.util.logging.*;

public class LoggerConfig {
    public static void setupLogger() {

        Logger rootLogger = Logger.getLogger("");

        Handler[] handlers = rootLogger.getHandlers();

        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);

        consoleHandler.setFormatter(new SimpleFormatter() {

            @Override
            public synchronized String format(LogRecord record) {

                return String.format(
                        "[%1$tF %1$tT] [%2$-7s] %3$s - %4$s %n",
                        record.getMillis(),
                        record.getLevel().getName(),
                        record.getLoggerName(),
                        record.getMessage()
                );
            }
        });

        rootLogger.addHandler(consoleHandler);
        rootLogger.setLevel(Level.INFO);
    }
}
