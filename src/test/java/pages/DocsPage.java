package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.LogUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocsPage extends BasePage {

    //*********Constructor*********
    public DocsPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.XPATH, using = "//section[text()='What is Angular']")
    public WebElement angularSection;

    @FindBy(how = How.XPATH, using = "//section[text()='Getting started']")
    public WebElement startedSection;

    By loginButton            = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

    public DocsPage thenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public DocsPage thenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public DocsPage thenIVerifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }

    public void checkPage() {
        assertTrue(angularSection.isDisplayed());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
