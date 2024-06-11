package config;

import org.aeonbits.owner.Config;

@Config.Sources(
        {"classpath:mobile.properties"}
)
public interface BrowserstackConfig extends Config {

    @Key("app")
    String applId();


    String device();

    @Key("os_version")
    String osVersion();

    @Key("browserstack_url")
    String browserstackURL();

    String project();


    String build();

    @Key("test_name")
    String testName();

}