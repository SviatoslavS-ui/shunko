package pages;

import libs.ActionsWithWebElements;
import libs.DealTimeAndDate;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DealsMenuPage {
    /* класс содержит переменные и методы для работы со страницей СДЕЛКИ */
    /* dealTimeAndDate - время и дата сделки, пришлось ввести новый класс для хранения этих данных */
    /* dealType - тип сделки */
    /* dealCustomer - покупатель */
    /* dealProvider - продавец */

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithWebElements actionsElements;

    String url = "http://v3.test.itpmgroup.com/deal";
       /* xPath locators for page elements */
    By dealType = By.xpath("//select[@id='deal_dealType']");
    By dealCustomer = By.xpath("//select[@id='deal_customer']");
    By dealProvider = By.xpath("//select[@id='deal_provider']");
    By addButtonXPath = By.xpath("//a[@class='btn btn-info btn-sm']");
    By createDealButtonXPath = By.xpath("//button[@name='add']");
    By dealDateXPath = By.xpath("//select[@id='deal_dealDate_date_day']");
    By dealMonthXPath = By.xpath("//select[@id='deal_dealDate_date_month']");
    By dealYearXPath = By.xpath("//select[@id='deal_dealDate_date_year']");
    By dealHourXPath = By.xpath("//select[@id='deal_dealDate_time_hour']");
    By dealMinuteXPath = By.xpath("//select[@id='deal_dealDate_time_minute']");

    public DealsMenuPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actionsElements = new ActionsWithWebElements(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get(url);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Couldn`t open the url");
        }
    }

    public void chooseDealTimeAndDate(DealTimeAndDate dealTimeAndDate) {
        actionsElements.selectElementFromDD(dealDateXPath, dealTimeAndDate.getDealDate());
        actionsElements.selectElementFromDD(dealMonthXPath, dealTimeAndDate.getDealMonth());
        actionsElements.selectElementFromDD(dealYearXPath, dealTimeAndDate.getDealYear());
        actionsElements.selectElementFromDD(dealHourXPath, dealTimeAndDate.getDealHour());
        actionsElements.selectElementFromDD(dealMinuteXPath, dealTimeAndDate.getDealMinute());
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
        actionsElements.clickButton(addButtonXPath);
    }

    public void clickCreateButton() {
        actionsElements.clickButton(createDealButtonXPath);
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
