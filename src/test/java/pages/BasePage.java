package pages;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {

        DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        waitForElementToBeClickable(element).click();

    }

    public void sendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element).sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitForElementToBeVisible(element).getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return waitForElementToBeVisible(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void switchToWindow() {
        String origin = DriverFactory.getDriver().getWindowHandle();
        for (String handle : DriverFactory.getDriver().getWindowHandles()) {
            if (!handle.equals(origin)) {
                DriverFactory.getDriver().switchTo().window(handle);
                return;
            }
        }
        DriverFactory.getDriver().switchTo().window(origin);
    }


        public void scrollToElement(WebElement element) {
            WebDriver driver = DriverFactory.getDriver();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        }

    public static void waitForPageToLoad() {
        new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(30)).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );

    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement whichActiveElement(WebElement element1, WebElement element2) {
        if (isElementPresent(element1)) {
            return element1;
        } else {
            return element2;
        }


    }
}
