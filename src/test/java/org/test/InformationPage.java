package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {

    public WebDriver driver;
    public InformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='postal-code']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@id='continue']")
    private WebElement signInButtonContinue;

    @FindBy(xpath = "//*[@id='finish']")
    private WebElement signInButtonFinish;

    public void inputFirstName(String fName) {
        firstName.sendKeys(fName);
    }
    public void inputLastName(String lName) {
        lastName.sendKeys(lName);
    }
    public void inputZipCode(String zCode) {
        zipCodeField.sendKeys(zCode);
    }
    public void clickSignInButtonContinue() {
        signInButtonContinue.click();
    }
    public void clickSignInButtonFinish() {
        signInButtonFinish.click();
    }

    public void informationPages(String fName, String lName, String zCode) {
        inputFirstName(fName);
        inputLastName(lName);
        inputZipCode(zCode);
        clickSignInButtonContinue();
        clickSignInButtonFinish();
    }
}
