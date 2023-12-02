import org.openqa.selenium.By;

public class Registration_Page extends Utils
{
    static String email = "simpsonhomer"+timeStamp()+"@outlook.co.uk";

    public void verifyPageURL() {
        waitforUrltobe(10);
    }
    public void userSubmitRegistrationFormSuccessfully() {

        //selects male radio button and clicks in the registration form.....

        clickonElements(By.xpath("//input[@id=\"gender-male\"]"));

        //selects first name text box and inputs given name in the box.......
        TypetextofElements(By.xpath("//input[@type=\"text\" and @id=\"FirstName\"]"), ("Homer"));

        //selects last name text box and inputs given last name in the box.......
        TypetextofElements(By.xpath("//input[@type=\"text\" and @id=\"LastName\"]"), ("Simpson"));

        SelectElement(By.name("DateOfBirthDay"), ("8")); //selects the Birth day from the dropdown menu......

        SelectbyIndex(By.xpath("//select[@name=\"DateOfBirthMonth\"]"), (5)); //Selects the Birth Month from dropdown menu......

        SelectbyIndex(By.xpath("//select[@name=\"DateOfBirthYear\"]"), (10));// Selects the birth year from the dropdown menu....

        //selects email text box and inputs given email address in the box.......
        TypetextofElements(By.xpath("//input[@type=\"email\" and @id=\"Email\"]"), email);


        //selects check box button and unchecks the Newsletter button......
        clickonElements(By.xpath("//input[@type=\"checkbox\" and @id=\"Newsletter\"]"));

        //selects Password text box and inputs given Password in the box.......
        TypetextofElements(By.id("Password"), ("Homer1234"));

        //selects Confirm password text box and inputs given Password in the box second time.......
        TypetextofElements(By.id("ConfirmPassword"), ("Homer1234"));

        //wait until the element is visible....
        waituntilvisible(By.id("register-button"), 5);

        //selects REGISTER submit button and clicks the button.......
        clickonElements(By.id("register-button"));

    }
}
