package MantisBTPages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */
public class ResultsPage extends Page {

    @FindBy(how = How.XPATH, using = "//h3[@class='r']/a")
    public List<WebElement> resultsList;

    @FindBy(how = How.XPATH, using = "//a[@id='pnnext']/span")
    public WebElement nextResultsPage;

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MantisBTHomePage selectResult(String mantisBT) {
        boolean found = false;
        while (!found) {
            for (WebElement element : resultsList){
                if (element.getText().contains(mantisBT)) {
                    element.click();
                    found = true;
                    break;
                }
            }
            if (!found){
                nextResultsPage.click();
                webDriver.navigate().refresh();
            }
        }
        return PageFactory.initElements(webDriver, MantisBTHomePage.class);
    }

}