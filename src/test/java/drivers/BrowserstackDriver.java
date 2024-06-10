package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    public static final DriverConfig config = ConfigFactory.create(DriverConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("user", config.getUser());
        caps.setCapability("key", config.getKey());

        // Set URL of the application under test
        caps.setCapability("app", config.getApp());

        // Specify device and os_version for testing

        caps.setCapability("device", config.getPlatform());
        caps.setCapability("os_version", config.getVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", config.getProject());
        caps.setCapability("build", config.getBuild());
        caps.setCapability("name", config.getName());
        System.out.println(config.toString());
        try {
            return new RemoteWebDriver(
                    new URL(config.getBaseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}