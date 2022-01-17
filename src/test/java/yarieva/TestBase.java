package yarieva;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import yarieva.pages.RegistrationsPage;

public class TestBase {
    RegistrationsPage registrationsPage = new RegistrationsPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "2048x1153";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
