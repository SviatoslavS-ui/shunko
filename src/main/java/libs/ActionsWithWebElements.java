package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.Select;

public class ActionsWithWebElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionsWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterTextToTextFields(By element, String text) {
        try {
            webDriver.findElement(element).clear();
            webDriver.findElement(element).sendKeys(text);
            logger.info("");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
        }
    }

    public void clickButton(By element) {
        try {
            webDriver.findElement(element).click();
            logger.info("");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
        }
    }


    public boolean isElementDisplayed(String element) {
        try {
            return webDriver.findElement(By.xpath(element)).isDisplayed();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(By element, boolean state) {
        try {
            if (webDriver.findElement(element).isSelected() != state) {
                webDriver.findElement(element).click();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
            return;
        }
    }

    public void selectElementFromDD(By element, String itemName) {
        Select dropDownValue = new Select(webDriver.findElement(element));
        try {
            dropDownValue.selectByVisibleText(itemName);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
        }
    }
}
