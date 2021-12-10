package testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class TestNgMavenExampleTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    @Test
    public void run() {
        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is warn message");
        LOGGER.error("This is error message");
        LOGGER.fatal("This is dangerous ");
        LOGGER.trace("General Message");
    }

//    @Test
    public void testPropertyFiles() {
        LOGGER.info(ReadConfigFiles.getPropertyValues("DbUser"));
    }
}
