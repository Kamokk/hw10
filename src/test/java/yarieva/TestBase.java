package yarieva;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import yarieva.config.CredentialsConfig;
import yarieva.helpers.Attach;
import yarieva.pages.RegistrationsPage;

import static java.lang.String.format;


public class TestBase {
    RegistrationsPage registrationsPage = new RegistrationsPage();


    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.startMaximized = true;
        CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
        String url = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        Configuration.remote = format("https://%s:%s@%s", credentials.login(), credentials.password(), url);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
