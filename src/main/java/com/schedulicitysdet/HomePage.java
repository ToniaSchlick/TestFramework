package com.schedulicitysdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    static String url = "https://www.way2automation.com/protractor-angularjs-practice-website.html";
    static By linkboxLinksSelectorLocator = By.cssSelector("div.linkbox>ul>li");

    public void goTo() {
        Browser.goTo(url);
    }

    public static void clickBoxLinkByText(String linkText) {
        List<WebElement> boxlinks = Browser.getElementList(linkboxLinksSelectorLocator);
        findTargetElementByText(boxlinks, linkText).click();
        Browser.getNewTab();
    }

    public static WebElement findTargetElementByText(List<WebElement> elementList, String text){
        return elementList.stream().filter(
                element -> element.getText().equals(text)).collect(Collectors.toList()).get(0);
    }

}
