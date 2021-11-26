package tests;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageGenerator;
import utils.ChromeOps;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageGenerator page;

    @BeforeEach
    public void classLevelSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "test-type",
                "--incognito",
                "--no-sandbox",
                "--disable-infobars",
                "--start-fullscreen",
                "--ignore-ssl-errors=yes",
                "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        page = new PageGenerator(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
        System.out.println("Thread name " + Thread.currentThread().getName() +" finished");
    }
}
