package LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;


public class LogTest {

    private WebDriver webDriver = DriverInit();
    private WebDriver DriverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public void validLogin() {
        webDriver.get("http://v3.test.itpmgroup.com/login");
        webDriver.findElement(By.name("_username")).clear();
        webDriver.findElement(By.name("_username")).sendKeys("Student");
        webDriver.findElement(By.name("_password")).clear();
        webDriver.findElement(By.name("_password")).sendKeys("909090");
      //  Assert.assertTrue();

    }
}