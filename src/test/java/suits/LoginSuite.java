package suits;

import LoginTest.AddDealWithDealPageTest;
import LoginTest.DeleteDealWithDealPageTest;
import LoginTest.EditDealWithDealPageTest;
import LoginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                AddDealWithDealPageTest.class,
                DeleteDealWithDealPageTest.class,
                EditDealWithDealPageTest.class
        }
)
public class LoginSuite {
}
