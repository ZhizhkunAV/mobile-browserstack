package drivers;

import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${env}.properties"

})
public interface DriverConfig extends Config {
    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("app")
    String getApp();

    @Key("platform")
    String getPlatform();

    @Key("baseurl")
    String getBaseUrl();

    @Key("version")
    String getVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();
}
