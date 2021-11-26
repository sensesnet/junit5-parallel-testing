package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://angular.io/";

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//span[text()='Features']")
    public WebElement featureLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Docs']")
    public WebElement docsLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Resources']")
    public WebElement resourcesLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Events']")
    public WebElement eventsLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Blog']")
    public WebElement blogLink;

    //*********Page Methods*********
    //Go to Homepage
    public HomePage givenIAmAtHomePage() {
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public FeaturePage whenIGoToFeaturePage() {
        click(featureLink);
        return new PageFactory().initElements(driver, FeaturePage.class);
    }
    public DocsPage whenIGoToDocsPage() {
        click(docsLink);
        return new PageFactory().initElements(driver, DocsPage.class);
    }
    public ResourcePage whenIGoToResourcesPage() {
        click(resourcesLink);
        return new PageFactory().initElements(driver, ResourcePage.class);
    }
}