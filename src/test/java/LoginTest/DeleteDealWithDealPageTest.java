package LoginTest;

import ParentTests.AbstractParentTest;
import org.junit.Test;

public class DeleteDealWithDealPageTest extends AbstractParentTest {

    @Test
    public void validDeleteDeal() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        dealPage.openPage();

        int count = dealPage.dealsQuantity();
        System.out.println("Now we have "+count+" deals");
        dealPage.deleteDeal(count);
        count = dealPage.dealsQuantity();
        System.out.println("Now we have "+count+" deals");
    }
}
