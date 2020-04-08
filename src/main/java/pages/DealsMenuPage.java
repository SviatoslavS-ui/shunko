package pages;

import libs.ActionsWithWebElements;
import libs.ConfigClass;
import libs.DealTimeAndDate;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;


public class DealsMenuPage extends ParentPage {
    /* класс содержит переменные и методы для работы со страницей СДЕЛКИ */
    /* dealTimeAndDate - время и дата сделки, пришлось ввести новый класс для хранения этих данных */
    /* dealType - тип сделки */
    /* dealCustomer - покупатель */
    /* dealProvider - продавец */


    String url = "http://v3.test.itpmgroup.com/deal";
       /* xPath locators for page elements */

    @FindBy(xpath = "//select[@id='deal_dealType']")
    private WebElement dealType;
    // By dealType = By.xpath("//select[@id='deal_dealType']");
    @FindBy(xpath = "//select[@id='deal_customer']")
    private WebElement dealCustomer;
    // By dealCustomer = By.xpath("//select[@id='deal_customer']");
    @FindBy(xpath = "//select[@id='deal_provider']")
    private WebElement dealProvider;
    // By dealProvider = By.xpath("//select[@id='deal_provider']");
    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    private WebElement addDealButton;
    // By addButtonXPath = By.xpath("//a[@class='btn btn-info btn-sm']");
    @FindBy(xpath = "//button[@name='add']")
    private WebElement createDealButton;
    // By createDealButtonXPath = By.xpath("//button[@name='add']");
    @FindBy(xpath = "//select[@id='deal_dealDate_date_day']")
    private WebElement dealDateXpath;
    // By dealDateXPath = By.xpath("//select[@id='deal_dealDate_date_day']");
    @FindBy(xpath = "//select[@id='deal_dealDate_date_month']")
    private WebElement dealMonthXpath;
    // By dealMonthXPath = By.xpath("//select[@id='deal_dealDate_date_month']");
    @FindBy(xpath = "//select[@id='deal_dealDate_date_year']")
    private WebElement dealYearXpath;
    // By dealYearXPath = By.xpath("//select[@id='deal_dealDate_date_year']");
    @FindBy(xpath = "//select[@id='deal_dealDate_time_hour']")
    private WebElement dealHourXpath;
    // By dealHourXPath = By.xpath("//select[@id='deal_dealDate_time_hour']");
    @FindBy(xpath = "//select[@id='deal_dealDate_time_minute']")
    private WebElement dealMinuteXpath;
    // By dealMinuteXPath = By.xpath("//select[@id='deal_dealDate_time_minute']");

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
    /* метод добавляющий новую сделку */
    public void addNewDeal(DealTimeAndDate dealTimeAndDate, String dealTypeName, String dealCustomerName, String dealProviderName) {
      clickAddButton();
      chooseDealTimeAndDate(dealTimeAndDate);
      chooseDealType(dealTypeName);
      chooseDealCustomer(dealCustomerName);
      chooseDealProvider(dealProviderName);
      clickCreateButton();
    }

}
