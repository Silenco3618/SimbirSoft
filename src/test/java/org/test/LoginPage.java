package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static String PAGE_URL = "https://www.saucedemo.com/";
    public WebDriver driver;

    @FindBy(xpath = "//*[@id='user-name']")
    private WebElement nameField;

    @FindBy(xpath = "//*[@data-test='password']")
    private WebElement passwdField;
    @FindBy(css = "[data-test='login-button']")
    private WebElement getSignInButtonLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void inputUsername(String login) {
        nameField.sendKeys(login); }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }

    public void clickLogin() {
        getSignInButtonLogin.click(); }

    public void loginPages(String login, String passwd) {
        inputUsername(login);
        inputPasswd(passwd);
        clickLogin();
    }
}
