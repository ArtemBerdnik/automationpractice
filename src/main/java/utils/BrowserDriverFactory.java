package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;


    public BrowserDriverFactory(String browser) {
        this.browser = browser.toLowerCase();
    }


    public WebDriver createDriver() {
        System.out.println("Starting " + browser + " locally");

        // Creating driver
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }

        return driver.get();
    }


    public WebDriver createDriverGrid() {
        String hubUrl = "http://192.168.56.1:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.out.println("Starting " + browser + " on grid");

        // Creating driver
        switch (browser) {
            case "chrome":
                capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
                break;
        }

        try {
            driver.set(new RemoteWebDriver(new URL(hubUrl), capabilities));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver.get();
    }


}
