import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestRun {
    public static WebDriver driver = null;
    @BeforeClass
    public static void startTest(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Test Start.");
        driver.get("https://www.saucedemo.com/");
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Test End.");
        driver.close();
    }

    @Test
    @DisplayName("Login Test.")
    @Order(1)
    public void loginTest(){
        By user = By.id("user-name");
        By pass = By.id("password");

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle,"Swag Labs");

        WebElement userInput = driver.findElement(user);
        WebElement passInput = driver.findElement(pass);
        userInput.clear();
        userInput.sendKeys("standard_user");
        passInput.clear();
        passInput.sendKeys("secret_sauce");
        passInput.sendKeys(Keys.ENTER);
    }

    @Test
    @DisplayName("Add Product Test")
    @Order(2)
    public void addProductToBasket(){
        By tShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
        By cartQuantity = By.xpath("//span[@class='shopping_cart_badge']");

        WebElement addShirtToBasket = driver.findElement(tShirt);
        addShirtToBasket.click();

        String quantity = driver.findElement(cartQuantity).getText();
        Assert.assertEquals(1,Integer.parseInt(quantity));
    }
}
