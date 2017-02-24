package MantisBTTests;

import MantisBTPages.Pages.GooglePage;
import MantisBTPages.Pages.MantisStablePage;
import MantisBTPages.webDriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */

public class TestBase {
    protected static WebDriver webDriver;
    protected GooglePage google;
    protected MantisStablePage mantisStable;

    @BeforeSuite
    @Parameters({ "browserName"})
    public void beforeSuite(String browserName) throws Exception {
        webDriver = WebDriverFactory.getInstance(browserName);
        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get("https://google.com");
        google = PageFactory.initElements(webDriver, GooglePage.class);
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        if (webDriver != null) {
            WebDriverFactory.killDriverInstance();
        }
    }
}
