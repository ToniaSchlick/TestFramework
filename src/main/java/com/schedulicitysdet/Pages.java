package com.schedulicitysdet;

public class Pages {

    public static HomePage homePage() {
        HomePage homePage = new HomePage();
        return homePage;
    }

    public static RegistrationPage registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage();
        return registrationPage;
    }

    public static WebTablesPage webTablesPage() {
        WebTablesPage webTablesPage = new WebTablesPage();
        return webTablesPage;
    }
}
