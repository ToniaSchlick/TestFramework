package com.schedulicitysdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    static String validUsername = "angular";
    static String validPassword = "password";
    static By LoginButtonLocator = By.cssSelector("button.btn.btn-danger");
    static By loginSuccessMessageLocator = By.linkText("Logout");
    static By loginFailureMessageLocator = By.className("alert");

    public static void completeLoginForm(boolean validUser, boolean validPass) {
        Browser.inputToField(By.id("username"), validUser ? validUsername : "invalidUserName");
        Browser.inputToField(By.id("password"), validPass ? validPassword : "invalidPassword");
        Browser.inputToField(By.id("formly_1_input_username_0"), "nunEmptyString");
        Browser.getElement(LoginButtonLocator).click();
    }

    public static boolean loginSuccess() {
        WebElement logoutButton = Browser.getElement(loginSuccessMessageLocator);
        boolean status = logoutButton.isDisplayed();
        if (status) {
            logoutButton.click();
        }
        return status;
    }

    public static boolean loginFailure() {
        WebElement loginFailureMessage = Browser.getElement(loginFailureMessageLocator);
        return loginFailureMessage.isDisplayed();
    }

}
