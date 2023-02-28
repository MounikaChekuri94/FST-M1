package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class Activity9 {
    WebDriver driver;
    private Instant wait;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void Contact() throws InterruptedException {

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
        Thread.sleep(3000);
        String contact = driver.findElement(
                By.xpath("//*[@id=\"emgcontact_list\"]")).getText();
System.out.println(contact);

    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
