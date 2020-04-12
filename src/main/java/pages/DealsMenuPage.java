package pages;

import libs.ConfigClass;
import libs.DealTimeAndDate;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;


public class DealsMenuPage extends ParentPage {
    /* класс содержит переменные и методы для работы со страницей СДЕЛКИ */
    /* dealTimeAndDate - время и дата сделки, пришлось ввести новый класс для хранения этих данных */

    @FindBy(xpath = "//select[@id='deal_dealType']")
    private WebElement dealType;

    @FindBy(xpath = "//select[@id='deal_customer']")
    private WebElement dealCustomer;

    @FindBy(xpath = "//select[@id='deal_provider']")
    private WebElement dealProvider;

    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement addDealButton;

    @FindBy(xpath = "//button[@name='add']")
    private WebElement createDealButton;

    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteDealButton;

    @FindBy(xpath = "//button[@name='save']")
    private WebElement saveDealButton;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_day']")
    private WebElement dealDateXpath;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_month']")
    private WebElement dealMonthXpath;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_year']")
    private WebElement dealYearXpath;

    @FindBy(xpath = "//select[@id='deal_dealDate_time_hour']")
    private WebElement dealHourXpath;

    @FindBy(xpath = "//select[@id='deal_dealDate_time_minute']")
    private WebElement dealMinuteXpath;

    public DealsMenuPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get(ConfigClass.getConfigValue("base_url") + "/deal");
            logger.info("Deals page was opened");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Cannot open file");
            Assert.fail("Cannot open file");
        }
    }

    public void chooseDealTimeAndDate(DealTimeAndDate dealTimeAndDate) {
        actionsElements.selectElementFromDD(dealDateXpath, dealTimeAndDate.getDealDate());
        actionsElements.selectElementFromDD(dealMonthXpath, dealTimeAndDate.getDealMonth());
        actionsElements.selectElementFromDD(dealYearXpath, dealTimeAndDate.getDealYear());
        actionsElements.selectElementFromDD(dealHourXpath, dealTimeAndDate.getDealHour());
        actionsElements.selectElementFromDD(dealMinuteXpath, dealTimeAndDate.getDealMinute());
    }

    public void chooseDealType(String dealTypeName) {
        actionsElements.selectElementFromDD(dealType, dealTypeName);
    }

    public void chooseDealCustomer(String dealCustomerName) {
        actionsElements.selectElementFromDD(dealCustomer, dealCustomerName);
    }

    public void chooseDealProvider(String dealProviderName) {
        actionsElements.selectElementFromDD(dealProvider, dealProviderName);
    }

    public void clickAddButton() {
        actionsElements.clickButton(addDealButton);
    }

    public void clickCreateButton() {
        actionsElements.clickButton(createDealButton);
    }

    public void clickDeleteButton() {
        actionsElements.clickButton(deleteDealButton);
    }

    public void clickSaveButton() {
        actionsElements.clickButton(saveDealButton);
    }

    /* метод возвращает общее количество сделок в таблице сделок */
    public int dealsQuantity() {
        return actionsElements.countTableRows(webDriver);
    }

    /* метод добавляющий новую сделку, возвращает порядковый номер сделки в таблице */
    public int addNewDeal(DealTimeAndDate dealTimeAndDate, String dealTypeName, String dealCustomerName, String dealProviderName) {
        int dealIndex = actionsElements.countTableRows(webDriver);
        clickAddButton();
        chooseDealTimeAndDate(dealTimeAndDate);
        chooseDealType(dealTypeName);
        chooseDealCustomer(dealCustomerName);
        chooseDealProvider(dealProviderName);
        clickCreateButton();
        // verifying is deal added
        if (actionsElements.countTableRows(webDriver) == ++dealIndex) {
            logger.info("It seems deal added succesfully ...");
            return dealIndex;
        } else {
            logger.info("Deal didn`t add ...");
            return -1;
        }
    }

    /* метод удаляющий сделку, index - порядковый номер сделки в таблице */
    public void deleteDeal(int index) {
        String adress = "//tr[" + index + "]//td[2]";
        WebElement currentDeal = null;
        try {
            currentDeal = webDriver.findElement(By.xpath(adress));
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            logger.error("Given table row cannot be located");
        }
        int dealIndex = actionsElements.countTableRows(webDriver);
        currentDeal.click();
        clickDeleteButton();
        // verifying is deal deleted
        if (actionsElements.countTableRows(webDriver) == --dealIndex) {
            logger.info("It seems deal " + index + " deleted succesfully ...");
        }
    }

    /* метод редактирующий сделку, index - порядковый номер сделки в таблице */
    public void editDeal(int index, DealTimeAndDate dealTimeAndDate, String dealTypeName, String dealCustomerName, String dealProviderName) {
        String adress = "//tr[" + index + "]//td[2]";
        WebElement currentDeal = null;
        try {
            currentDeal = webDriver.findElement(By.xpath(adress));
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            logger.error("Given table row cannot be located");
        }
        currentDeal.click();
        chooseDealTimeAndDate(dealTimeAndDate);
        chooseDealType(dealTypeName);
        chooseDealCustomer(dealCustomerName);
        chooseDealProvider(dealProviderName);
        clickSaveButton();
        logger.info("It seems deal edited succesfully ...");
    }

}
