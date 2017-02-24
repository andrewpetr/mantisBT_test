package MantisBTPages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */
public class MantisBTHomePage extends Page{

    @FindBy(how = How.XPATH, using = "//a[@class='files']")
    public WebElement filesTab;

    public MantisBTHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MantisBTFilesPage navigateToFiles() {
        filesTab.click();
        return PageFactory.initElements(webDriver, MantisBTFilesPage.class);
    }
}
