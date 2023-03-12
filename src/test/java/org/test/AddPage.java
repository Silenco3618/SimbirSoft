package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPage {

    public WebDriver driver;
    public AddPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement signInButtonAdd;

    @FindBy(css = "[class='shopping_cart_container']")
    private WebElement signInButtonCard;

    @FindBy(xpath = "//*[@id='checkout']")
    private WebElement signInButtonCheckout;

    public void addPages() {
        clickAdd();
        clickCard();
        clickCheckout();
    }

    public void clickAdd() {
        signInButtonAdd.click();
    }

    public void clickCard() {
        signInButtonCard.click();
    }

    public void clickCheckout() {
        signInButtonCheckout.click();
    }
}