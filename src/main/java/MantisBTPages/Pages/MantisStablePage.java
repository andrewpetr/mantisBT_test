package MantisBTPages.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */
public class MantisStablePage extends Page{

    @FindBy(how = How.XPATH, using = "//td[@headers='files_downloads_h']")
    public List<WebElement> listOfDownloads;

    @FindBy(how = How.XPATH, using = "//th[@headers='files_name_h']/a[@class='name']")
    public List<WebElement> listOfVersions;

    public MantisStablePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getVersionThatHasTheMostNumbersOfDownloading() throws ParseException {
        NumberFormat numFormat = NumberFormat.getNumberInstance(Locale.US);
        int maxNumberIndex = 0;
        for (int i = 1; i < listOfDownloads.size()-1; i++) {
            int newNumber = numFormat.parse(listOfDownloads.get(i).getText()).intValue();
            if ((newNumber > numFormat.parse(listOfDownloads.get(maxNumberIndex).getText()).intValue())) {
                maxNumberIndex = i;
            }
        }
        System.out.println("\n\nVersion of MantisBT that has the most numbers of downloading is : "
                + listOfVersions.get(maxNumberIndex).getText() + "\n");
        return listOfVersions.get(maxNumberIndex).getText();
    }
}
