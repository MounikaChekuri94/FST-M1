package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void Login() throws InterruptedException {

        WebElement username= driver.findElement(By.id("txtUsername"));
        WebElement password= driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_dashboard_index"));

   //     driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]")).click();


        System.out.println("logged in");




    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

