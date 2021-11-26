package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.HomePage;

@Execution(ExecutionMode.CONCURRENT)
public class CopyOfLoginTest extends BaseTest {
    @Test
    public void invalidLoginTest_InvalidUserNameInvalidPassword2() {
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .whenIGoToResourcesPage()
                .checkPage();
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .whenIGoToFeaturePage()
                .checkPage();
    }

    @Test
    public void invalidLoginTest_EmptyUserEmptyPassword2() {
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .whenIGoToFeaturePage()
                .checkPage();
    }
}
