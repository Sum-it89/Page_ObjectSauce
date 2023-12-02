import org.testng.annotations.Test;

public class Test_Suite extends BaseTest
{
    HomePage homePage = new HomePage();
    Registration_Page registrationPage = new Registration_Page();
    Registration_Result registrationResult = new Registration_Result();
    Login logIn = new Login();



    @Test(priority = 1)
    public void userIsAbleToRegisterSuccessfully()
    {
        homePage.waitUntilRegistrationLinkClickable();//waits until the Registration button is clickable.
        homePage.clickOnRegisterLink();//clicks on the Register Link.
        registrationPage.verifyPageURL();//verify Weather the landing page is registration page.
        registrationPage.userSubmitRegistrationFormSuccessfully();//fills the registration form with personal details and submits.
        registrationResult.waitsForSubmitButtonToDisappear();//Page waits until the submit button is disappeared.
        registrationResult.verifiesTheRegisteredMessageIsCorrect();//captures and verifies the registration complete message.
    }

    @Test (priority = 2)
    public void userIsAbleToLogINSuccessfully()
    {
        logIn.verifyIfUserisLoggedIn();//Verifies weather user is logged in already or not.
        logIn.userShouldLogInSuccessfully();//clicks on log in button and fills log in information of registered user.
    }

}
