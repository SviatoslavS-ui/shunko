package LoginTest;

import ParentTests.AbstractParentTest;
import libs.DealTimeAndDate;
import org.junit.Test;

public class AddDealWithDealPageTest extends AbstractParentTest {
    DealTimeAndDate testTimeandDate = new DealTimeAndDate("19","окт.","2020", "03", "10");

    @Test
    public void validAddDeal() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        dealPage.openPage();
        dealPage.addNewDeal(testTimeandDate,"обмен", "test", "test");
        checkExpectedResult("Add deal succesfull", false);
    }
}
