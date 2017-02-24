package MantisBTPages.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */
public class GooglePage extends Page {

    @FindBy (how = How.XPATH, using = "//input[@id='lst-ib']")
    public WebElement searchField;

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultsPage search(String mantis) {
        searchField.sendKeys(mantis + Keys.ENTER);
         return PageFactory.initElements(webDriver, ResultsPage.class);
    }
}
