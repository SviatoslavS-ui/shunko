package suits;

import LoginTest.LoginWithPageObjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginWithPageObjectTest.class,
                LoginWithPageObjectTest.class
        }
)
public class LoginSuite {
}
