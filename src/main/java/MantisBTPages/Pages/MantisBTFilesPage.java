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
public class MantisBTFilesPage extends Page{

    @FindBy(how = How.XPATH, using = "//th[@headers='files_name_h']/a")
    public List<WebElement> listOfFiles;

    public MantisBTFilesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MantisStablePage selectMantis(String file) {
        for (WebElement element : listOfFiles){
            if (element.getText().equalsIgnoreCase(file)){
                element.click();
                break;
            }
        }
        return PageFactory.initElements(webDriver, MantisStablePage.class);
    }
}
