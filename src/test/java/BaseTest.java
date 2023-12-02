import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BrowserManager
{
    @BeforeMethod
    public void setup(){
        //OpenBrowser();
        openBrowserWithSauce();

    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        System.out.println("hgkdfhgjkfdgjkdfjkgdfjkg");

        if(!(result.isSuccess()))
        {
            captureScreenshot(result.getName());
        }

        closeBrowser();
    }
}
