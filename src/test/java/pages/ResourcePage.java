package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.LogUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourcePage extends BasePage {

    //*********Constructor*********
    public ResourcePage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.XPATH, using = "//button[text()='Development']")
    public WebElement developmentButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Education']")
    public WebElement educationButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Community']")
    public WebElement communityButton;

    By loginButton            = By.id("loginButton");
    By errorMessageUsernameBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div");

//    //*********Page Methods*********
//    public ResourcePage andILoginToN11(String userName, String password) {
//        writeText(this.userName, userName);
//        writeText(this.password, password);
//        jsClick(loginButton);
//        return this;
//    }

    public ResourcePage thenIVerifyLoginUserNameErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessageUsernameBy));
        return this;
    }

    public ResourcePage thenIVerifyPasswordErrorMessage(String expectedText) {
        assertEquals(expectedText, readText(errorMessagePasswordBy));
        return this;
    }

    public ResourcePage thenIVerifyLogEntryFailMessage() {
        assertTrue(LogUtil.isLoginErrorLog(driver));
        return this;
    }

    public void checkPage() {
        assertTrue(educationButton.isDisplayed());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
