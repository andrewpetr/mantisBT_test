package MantisBTTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.ParseException;

/**
 * Created by Andrew Petrushchak on 22-Feb-17.
 */

public class MantisBTTest extends TestBase {

    @BeforeMethod
    @Parameters({"mantis", "linkMantisBT", "fileName"})
    public void BeforeMethod(String mantis, String linkMantisBT, String fileMantisStable){
        mantisStable = google
                .search(mantis)
                .selectResult(linkMantisBT)
                .navigateToFiles()
                .selectMantis(fileMantisStable);
    }

    @Test
    @Parameters({"expectedVersion"})
    public void MantisVersion(String expectedVersion) throws ParseException {
        Assert.assertEquals(mantisStable.getVersionThatHasTheMostNumbersOfDownloading(), expectedVersion);
    }
}
