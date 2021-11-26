package pages;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.LogUtil;

public class FeaturePage extends BasePage {

    //*********Constructor*********
    public FeaturePage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.XPATH, using = "//div[text()='Cross Platform']")
    public WebElement platform;


    By loginButton            = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

    //*********Page Methods*********
//    public FeaturePage andILoginToN11(String userName, String password) {
//        writeText(this.userName, userName);
//        writeText(this.password, password);
//        jsClick(loginButton);
//        return this;
//    }

    public FeaturePage thenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public FeaturePage thenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public FeaturePage thenIVerifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }

    public void checkPage() {
        assertTrue(platform.isDisplayed());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
