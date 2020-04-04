package pages;

import libs.ConfigClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLoginName;

    @FindBy(name = "_password")
    private WebElement inputLoginPassword;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement inputButtonXpath;

    @FindBy(xpath = ".//div[@class='login-box-body']")
    private WebElement loginBox;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPageLogin() {
        try {
            webDriver.get(ConfigClass.getConfigValue("base_url") + "/login");
            logger.info("Login page was opened");
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Cannot open file");
            Assert.fail("Cannot open file");
        }
    }

    public void inputLogin(String name) {
        actionsElements.enterTextToTextFields(inputLoginName, name);
    }

    public void inputPassword(String text) {
        actionsElements.enterTextToTextFields(inputLoginPassword, text);
    }

    public void clickSubmitButton() {
        actionsElements.clickButton(inputButtonXpath);
    }

    public boolean isLoginBoxRefreshed() {
        return actionsElements.isElementDisplayed(loginBox);
    }

    public void loginToPage(String login, String password) {
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();
    }
}
