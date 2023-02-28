package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Instant;

public class Activity4 {
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
    public void AddEmployee() throws InterruptedException {

        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.xpath("//input[@name='btnAdd']")).click();

        WebElement e1= driver.findElement(By.id("firstName"));
        e1.sendKeys("My");
        WebElement e3=  driver.findElement(By.id("lastName"));
        e3.sendKeys("123");
        driver.findElement(By.id("employeeId")).sendKeys("1001");
        //Find upload field
        File file = new File("C:\\IBM\\FST Training\\Act4.txt");
        WebElement uploadInput = driver.findElement(By.id("photofile"));
        uploadInput.sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//*[@id = 'btnSave']")).click();

        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']")).click();

        driver.findElement(By.xpath("//*[@id='empsearch_employee_name_empName']")).sendKeys(e1+" " +e3);
        System.out.println("employee search success");




    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}