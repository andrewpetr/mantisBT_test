package MantisBTPages.webDriver;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
    private static final String CHROME = "chrome";

    private static WebDriver webDriver;
    private static DesiredCapabilities dc;

    private WebDriverFactory() {

    }

    public static WebDriver getInstance(String browser) throws Exception {
        if (webDriver == null) {
            if (CHROME.equals(browser)) {

                setChromeDriver();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                dc = DesiredCapabilities.chrome();
                dc.setCapability(ChromeOptions.CAPABILITY, options);

                webDriver = new ChromeDriver(dc);

            } else
                throw new Exception("Invalid browser property set in configuration file");

        }

        return webDriver;
    }

    public static void killDriverInstance() throws Exception {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void setChromeDriver() throws Exception {
        String osName = System.getProperty("os.name").toLowerCase();
        StringBuffer chromeBinaryPath = new StringBuffer(
                "src/resources/drivers/");

        if (osName.startsWith("win")) {
            chromeBinaryPath.append("chrome-win/chromedriver.exe");
        } else if (osName.startsWith("lin")) {
            chromeBinaryPath.append("chrome-lin/chromedriver");
        } else if (osName.startsWith("mac")) {
            chromeBinaryPath.append("chrome-mac/chromedriver");
        } else
            throw new Exception("Your OS is invalid for webdriver tests");

        System.setProperty("webdriver.chrome.driver",
                chromeBinaryPath.toString());
    }
}
