import org.openqa.selenium.By;
import org.testng.Assert;

public class Registration_Result extends Utils
{
    public void waitsForSubmitButtonToDisappear() {

        waitforinvisible(By.id("register-button"), (5));
    }

    public void verifiesTheRegisteredMessageIsCorrect() {
        //Verifies the registered message is correct or not............................
        Assert.assertEquals(getTextElement(By.className("result")), "Your registration completed", "Expected message does not match the actual");
    }
}
