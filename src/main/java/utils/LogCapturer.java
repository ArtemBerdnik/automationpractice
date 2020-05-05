package utils;

import com.google.common.io.BaseEncoding;
import lombok.Getter;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;


public class LogCapturer {

    @Getter
    private static final Logger LOGGER = LogManager.getLogger(Logger.class);

    @SneakyThrows
    public static void logInfoEventWithScreenshot(String message) {
        File screenshotFile = ((TakesScreenshot)TestUtils.getDriver()).getScreenshotAs(OutputType.FILE);
        LOGGER.info("RP_MESSAGE#BASE64#{}#{}",
                BaseEncoding.base64().encode(Files.readAllBytes(screenshotFile.toPath())),
                message);
    }
    @SneakyThrows
    public static void logInfoEventWithoutScreenshot(String message) {
        LOGGER.info(message);
    }
}
