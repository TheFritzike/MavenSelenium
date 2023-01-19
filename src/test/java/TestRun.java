import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestRun {
    @Test
    public void sauceDemoPage(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("Test Start.");

        //variables
        By user = By.id("user-name");
        By pass = By.id("password");

        //open page verify title
        driver.get("https://www.saucedemo.com/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Swag Labs");

        //insert user, password and press Enter
        WebElement userInput = driver.findElement(user);
        WebElement passInput = driver.findElement(pass);
        userInput.clear();
        userInput.sendKeys("standard_user");
        passInput.clear();
        passInput.sendKeys("secret_sauce");
        passInput.sendKeys(Keys.ENTER);

        //end test
        System.out.println("Test End.");
        driver.close();
    }
}
