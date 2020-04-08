package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

public class LoginWithPageObjectTest extends AbstractParentTest {

    @Test
    public void validLogin() {
        loginPage.openPageLogin();
        loginPage.inputLogin("Student");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();

        checkExpectedResult("Logging succesfull", false);
    }
}
