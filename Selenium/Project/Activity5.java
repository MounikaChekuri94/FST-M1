package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Instant;

public class Activity5 {
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
    public void EditEmp() throws InterruptedException {

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("ABC");
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("bin");
        driver.findElement(By.id("personal_optGender_2")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.id("personal_cmbNation")));
        dropdown.selectByVisibleText("Indian");
        Thread.sleep(2000);
        driver.findElement(By.id("personal_DOB")).sendKeys("20130212");
        Thread.sleep(2000);
        driver.findElement(By.id("btnAddAttachment")).click();
        Thread.sleep(2000);




    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
