package pl.coderslab.maven;

import org.apache.log4j.Logger;

public class Main1 {

    private static final Logger LOGGER = Logger.getLogger(Main1.class);

    public static void main(String[] args) {
        LOGGER.info("To jest komunikat testowy");
        LOGGER.error("To jest błąd krytyczny");
    }
}
