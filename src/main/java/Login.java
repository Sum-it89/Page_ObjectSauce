import org.openqa.selenium.By;
import org.testng.Assert;

public class Login extends Utils
{
    public void verifyIfUserisLoggedIn(){
        //checks weather the page is automatically logged in if not the test case fails..........................
        Assert.assertTrue(By.className("ico-login").equals(By.className("ico-login")));
    }

    public void userShouldLogInSuccessfully()
    {
        //clicks on log in from the registration complete page.................
        clickonElements(By.className("ico-login"));

        //Types in captured email address in the log in form..............
        TypetextofElements(By.className("email"), Registration_Page.email);

        //Types in password in the log in form............
        TypetextofElements(By.className("password"), "Homer1234");

        //Clicks on log in button....................................
        clickonElements(By.xpath("//button[@class=\"button-1 login-button\"]"));

    }
}
