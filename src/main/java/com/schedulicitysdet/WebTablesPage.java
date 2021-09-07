package com.schedulicitysdet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class WebTablesPage {

    static String url = "http://www.way2automation.com/angularjs-protractor/webtables";
    static By tableLocator = By.tagName("tbody");
    static By tableRowsLocator = By.tagName("tr");
    static By usernameColumnLocator = By.cssSelector("td:nth-child(3)");
    static By deleteButtonColumnLocator = By.cssSelector("td:nth-child(11)");
    static By deleteButtonLocator = By.tagName("button");
    static By confirmationModalLocator = By.cssSelector("div.modal.ng-scope");
    static By modalFooterLocator = By.className("modal-footer");
    static By footerButtons = By.tagName("button");
    static int OkButtonIndex = 1;

    public static void goTo() {
        Browser.goTo(url);
    }

    public static void deleteTableRowByUserName(String username) {
        List<WebElement> rows = getTableRows();
        WebElement targetRow = findTargetRow(rows, username).get(0);
        WebElement deleteButton = targetRow.findElement(deleteButtonColumnLocator).findElement(deleteButtonLocator);
        deleteButton.click();
    }

    public static List<WebElement> getTableRows() {
        WebElement table = Browser.getElement(tableLocator);
        return table.findElements(tableRowsLocator);
    }

    public static List<WebElement> findTargetRow(List<WebElement> rows, String username){
        return rows.stream().filter(
                row -> row.findElement(usernameColumnLocator)
                        .getText().equals(username)).collect(Collectors.toList());
    }

    public static void confirmDeletion(){
        WebElement modal = Browser.getElement(confirmationModalLocator);
        WebElement modalFooter = modal.findElement(modalFooterLocator);
        List<WebElement> buttons = modalFooter.findElements(footerButtons);
        buttons.get(OkButtonIndex).click();
    }

    public static boolean userWasDeleted(String username) {
        List<WebElement> rows = getTableRows();
        List<WebElement> usersFoundInTable = findTargetRow(rows, username);
        return (usersFoundInTable.size() == 0);
    }

}


