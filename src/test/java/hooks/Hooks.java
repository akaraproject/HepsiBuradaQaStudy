package hooks;

import driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;

public class Hooks {

    public static WebDriver webDriver = DriverFactory.getDriver();

    @Before("@UI")
    public void before() {

        webDriver.manage().window().maximize();

        webDriver.get(ConfigReader.get("url"));
    }

    @After ("@UI")
    public void after() {

        //webDriver.quit();
    }
}
