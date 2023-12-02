import org.openqa.selenium.By;

public class HomePage extends Utils

{
    private By releaseDetails = By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a");
    private By waitForRegister = By.linkText("Register");
    private int waitSec = 5;
    private By registerLink = By.linkText("Register");



    public void waitUntilRegistrationLinkClickable(){
        waituntilclickable(waitForRegister, waitSec);
    }
    public void clickOnRegisterLink (){
        clickonElements(registerLink);
    }

    public void waitUntilUserisInHomepage(){
        waitforUrltobe(waitSec);
    }

    public void clickOnNewsReleaseDetails(){
        clickonElements(releaseDetails);
    }
}
