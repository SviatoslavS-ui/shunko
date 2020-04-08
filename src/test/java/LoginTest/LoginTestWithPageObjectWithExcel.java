package LoginTest;


import ParentTests.AbstractParentTest;
import libs.ConfigClass;
import libs.ExcelDriver;
import org.junit.Test;
import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends AbstractParentTest {
    @Test
    public void validLogin() throws IOException {
        Map<String, String> dataForValidLogin = ExcelDriver.getData(ConfigClass.getConfigValue("DATA_FILE"), "validLogOn");

        loginPage.openPageLogin();
        loginPage.inputLogin(dataForValidLogin.get("login"));
        loginPage.inputPassword(dataForValidLogin.get("pass"));
        loginPage.clickSubmitButton();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }



}
