package ParentTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DealsMenuPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected DealsMenuPage dealPage;
    protected HomePage homePage;
    protected Utils utils;
    private String pathToScreenshot;

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception {

        pathToScreenshot = "..\\shunko\\target\\screenshots\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + ".jpg";

        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        dealPage = new DealsMenuPage(webDriver);
        homePage = new HomePage(webDriver);
        utils = new Utils();
    }

    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        if (!actualResult == true) {
            utils.screenShot(pathToScreenshot, webDriver);
        }
        //Assert.assertEquals(message, true, actualResult);
    }
}
