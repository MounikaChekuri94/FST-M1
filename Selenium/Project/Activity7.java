package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class Activity7 {
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
    public void Exp() throws InterruptedException {

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.xpath("//*[@id='sidenav']/li[9]/a")).click();
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test specialist");
        driver.findElement(By.id("btnWorkExpSave")).click();


    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
