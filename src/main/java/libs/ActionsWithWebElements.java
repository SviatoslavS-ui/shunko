package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionsWithWebElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToTextFields(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            logger.info("Text entered to field ..");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
            logger.info("Clicked ..");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }


    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state) {
        try {
            if (element.isSelected() != state) {
                element.click();
            }
            logger.info("The checkbox is"+state);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }

    public void selectElementFromDD(WebElement element, String itemName) {
        Select dropDownValue = new Select(element);
        try {
            dropDownValue.selectByVisibleText(itemName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Something went wrong");
        }
    }

    /* возвращает строку из таблицы на учебном сайте
    public String getTableRecord(int index) {
        By table;
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.get(index).getText();
    }
    // считает количество строк в таблице
    public int countTableRows() {
        By table;
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        return rows.size();
    } */

}
