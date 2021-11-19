package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.tests.config.CredentialsConfig;
import guru.qa.tests.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class BaseTest {
    public static CredentialsConfig registration =
            ConfigFactory.create(CredentialsConfig.class);
    @BeforeAll
    public static void setUp() {
        String login = registration.login();
        String password = registration.password();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@%s", login, password, System.getProperty("url"));
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "91.0");

    }

    @AfterEach
    void tearDown() {
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.addVideo();
    }
}
