package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Instant;

public class Activity6
{
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
    public void SearchDirectory() throws InterruptedException {

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        boolean t =driver.findElement(By.id("menu_directory_viewDirectory")).isDisplayed();
        if (t) {
            System.out.println("Element is dispalyed");
        } else {
            System.out.println("Element is not dispalyed");
        }
        boolean directory =driver.findElement(By.id("menu_directory_viewDirectory")).isEnabled();
        if (directory) {
            System.out.println("Element is clickable");
        } else {
            System.out.println("Element is not clickable");
        }
        driver.getPageSource().contains("Search Directory");
        System.out.println("search directory is present");




    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

