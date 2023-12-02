import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserManager extends Utils {

    URL url = null;
    LoadProp loadProp = new LoadProp();


    //String browserName = loadProp.getProperty("browser");
    String browserName = System.getProperty("browser");

    // boolean sauce = true;
    boolean sauce = Boolean.parseBoolean(System.getProperty("browser"));


    public void openBrowserWithSauce() {

        if (sauce)
        {

            System.out.println("running in sauce..............................");
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("username"));
                sauceOptions.put("accessKey", loadProp.getProperty("password"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);


                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, browserOptions);


            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
                Map<String, Object> sauceOptions = new HashMap<>();
                sauceOptions.put("username", loadProp.getProperty("username"));
                sauceOptions.put("accessKey", loadProp.getProperty("password"));
                sauceOptions.put("build", "<your build id>");
                sauceOptions.put("name", "<your test name>");
                browserOptions.setCapability("sauce:options", sauceOptions);

                try {
                    url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(url, browserOptions);

            } else {
                System.out.println("Your browse name is wrong or does not match :" + browserName);


            }
        } else {
            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {

                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.out.println("Browser is not correct:" + browserName);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public void closeBrowser() {
        driver.quit();

    }



//    public void OpenBrowser() {
//        if (browserName.equalsIgnoreCase("Chrome")) {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//            driver = new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("Firefox")) {
//
//            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
//            driver = new FirefoxDriver();
//
//        } else if (browserName.equalsIgnoreCase("Edge")) {
//            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
//            driver = new EdgeDriver();
//        }else {
//            System.out.println("Browser is not correct:" + browserName);
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        //driver.manage().window().fullscreen();
//        driver.manage().window().maximize();
//        driver.get("https://demo.nopcommerce.com/");
//    }



}
