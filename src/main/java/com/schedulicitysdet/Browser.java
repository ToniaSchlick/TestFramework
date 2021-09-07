package com.schedulicitysdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Browser {

    static WebDriver driver = new ChromeDriver();

    public static void goTo(String url) {
        driver.get(url);
    }

    public static WebElement getElement(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> getElementList(By locator) {
        return getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait;
    }

    public static void inputToField(By locator, String input) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(input);
    }

    public static void getNewTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(1));
    }

    public static void close() {
        driver.close();
    }

}

