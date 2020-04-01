package pages;

import libs.ActionsWithWebElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithWebElements actionsElements;

    By inputLoginName = By.name("_username");
    By inputPassword = By.name("_password");
    By inputButtonXpath = By.xpath(".//button[@type='submit']");
    String url = "http://v3.test.itpmgroup.com/login";

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        actionsElements = new ActionsWithWebElements(webDriver);
    }

    public void openPage(){
        try {
            webDriver.get(url);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void inputLogin(String name){
        actionsElements.enterTextToTextFields(inputLoginName, name);
    }
    public void inputPassword(String text){
        actionsElements.enterTextToTextFields(inputPassword, text);
    }
    public void clickSubmitButton(){
        actionsElements.clickButton(inputButtonXpath);
    }
    public void loginToPage(String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }
}
