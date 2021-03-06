package LoginTest;

import ParentTests.AbstractParentTest;
import libs.DealTimeAndDate;
import org.junit.Test;
import java.lang.System;

public class AddDealWithDealPageTest extends AbstractParentTest {
    DealTimeAndDate testTimeandDate = new DealTimeAndDate("19","окт.","2020", "03", "10");

    @Test
    public void validAddDeal() {
        int dealIndex = 0;
        loginPage.openPageLogin();
        loginPage.loginToPage("Student", "909090");
        dealPage.openPage();
        dealIndex = dealPage.addNewDeal(testTimeandDate,"обмен", "test", "test");
        if (dealIndex != -1) {
            System.out.println("Deal added number "+dealIndex);
        }
        checkExpectedResult("Add deal succesfull", false);
    }
}
