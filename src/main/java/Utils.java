import com.beust.ah.A;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Utils extends BasePage
{

    public static String nike;


    public static String timeStamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }


    public static void captureScreenshot(String screenShotName)
    {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File("ScreenshotsTS\\" + screenShotName +timeStamp()+ ".png"));
            System.out.println("Screenshot taken");
        }
        catch (IOException e)
        {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }


    public static void currencySymbols(By by) {

        List<WebElement> productsPrice = driver.findElements(by);
        System.out.println(productsPrice.size());
        List<String>productPriceList = new ArrayList<>();

        for (WebElement pricelist: productsPrice){
            productPriceList.add(pricelist.getText());
            System.out.println(pricelist.getText());
        }

    }

    public static String commentList(By by)
    {
        List<WebElement> comments = driver.findElements(by);
        List<String> commentsList = new ArrayList<>();
        String username = "";
        for (WebElement ele: comments)
        {
            commentsList.add(ele.getText());
            username = ele.getText();
            // System.out.println(username);
        }
        return username;

        // System.out.println(username);
        //Assert.assertEquals(username.contains, "Best Online Store to Buy Computer Components", "Does not exist");
    }

    public static String itemByBrand(By by){

        List<WebElement> brandedItems = driver.findElements(by);
        List<String> brandList = new ArrayList<>();
        for (WebElement ele: brandedItems)
        {
            brandList.add(ele.getText());
            nike = ele.getText();
            System.out.println(nike);

        }
        return nike;


    }






    public static void clickonElements(By by) {//click on elements........
        driver.findElement(by).click();
    }


    public static void TypetextofElements(By by, String text) {  //type text......
        driver.findElement(by).sendKeys(text);
    }


    public static String getTextElement(By by) {  //get text.................
        return driver.findElement(by).getText();
        //String registerSuccessText = driver.findElement((By.className("result"))).getText();
        //System.out.println(registerSuccessText);
    }

    public static void SelectElement(By by, String Text) {
        Select selectDay = new Select(driver.findElement(by));
        selectDay.selectByVisibleText(Text);
//        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
//        selectDay.selectByVisibleText("8");
    }


    public static void SelectbyIndex(By by, int index) {
        Select selectMonth = new Select(driver.findElement(by));
        selectMonth.selectByIndex(index);

//  Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
//  selectMonth.selectByIndex(5);
//  Select selectYear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
//  selectYear.selectByIndex(10);
    }

    public static void SelectByValue(By by, String value){
        Select selectCurrency = new Select(driver.findElement(by));
        selectCurrency.selectByValue(value);
    }


    public static void waituntilclickable(By by, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(by));
//  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
//  wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
    }

    public static void waituntilvisible(By by, int sec) {
        WebDriverWait visible = new WebDriverWait(driver, Duration.ofSeconds(sec));
        visible.until(ExpectedConditions.visibilityOfElementLocated(by));
//  WebDriverWait visible = new WebDriverWait(driver, Duration.ofSeconds(20));
//  visible.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-button")));
    }


    public static String waitforUrltobe(int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        String url = driver.getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(url));
        return url;
    }


    public static void waitforinvisible(By by, int sec) {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(by));
//  WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//  wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("register-button")));


    }


}

