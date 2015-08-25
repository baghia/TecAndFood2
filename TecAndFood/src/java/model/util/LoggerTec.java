package model.util;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import model.Usuario;

public class LoggerTec {

    public final Logger logger = Logger.getLogger(LoggerTec.class.getName());
    public FileHandler fileHandler;
    public ConsoleHandler consoleHandler;
    public SimpleFormatter simpleFormatter;

    public LoggerTec(Usuario user) throws SecurityException, IOException {
        /*Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(format.format(data));
        //String nome = "%h/logs/log_" + user.getNome() + "_" + format.format(data) + ".log";
        String nome = "C:/Users/Cliente/Documents/logs/logsTecAndFood/log" + user.getNome() + "_" + format.format(data) + ".log";

        this.simpleFormatter = new SimpleFormatter();

        this.fileHandler = new FileHandler(nome, true);
        this.fileHandler.setLevel(Level.INFO);
        this.fileHandler.setFormatter(simpleFormatter);

        this.consoleHandler = new ConsoleHandler();
        this.consoleHandler.setLevel(Level.INFO);
        this.consoleHandler.setFormatter(simpleFormatter);

        this.logger.addHandler(fileHandler);
        this.logger.removeHandler(consoleHandler);*/
    }

    public LoggerTec() throws SecurityException, IOException {
        /*Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(format.format(data));
        String nome = "%h/logs/log_" + format.format(data) + ".log";
        
        this.simpleFormatter = new SimpleFormatter();

        this.fileHandler = new FileHandler(nome, true);
        this.fileHandler.setLevel(Level.INFO);
        this.fileHandler.setFormatter(simpleFormatter);

        this.consoleHandler = new ConsoleHandler();
        this.consoleHandler.setLevel(Level.INFO);
        this.consoleHandler.setFormatter(simpleFormatter);

        this.logger.addHandler(fileHandler);
        this.logger.removeHandler(consoleHandler);*/
    }

    public void logInfo(String message) {
        this.logger.log(Level.INFO, message);
    }

    public void logSevere(String message, Exception ex) {
        this.logger.log(Level.SEVERE, message, ex);
    }

    public void logWarning(String message) {
        this.logger.log(Level.WARNING, message);
    }
}
