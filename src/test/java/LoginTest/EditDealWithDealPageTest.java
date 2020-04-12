package LoginTest;

import ParentTests.AbstractParentTest;
import libs.DealTimeAndDate;
import org.junit.Test;

public class EditDealWithDealPageTest extends AbstractParentTest {
    DealTimeAndDate testTimeAndDate = new DealTimeAndDate("19","окт.","2015", "03", "10");

    @Test
    public void validEditDeal() {
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        dealPage.openPage();
        int dealIndex = dealPage.dealsQuantity();
        System.out.println("Now we are editing "+dealIndex+" deal");
        dealPage.editDeal(dealIndex, testTimeAndDate, "обмен", "test", "2Вася");
        checkExpectedResult("Add deal succesfull", false);
    }
}
