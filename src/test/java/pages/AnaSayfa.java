package pages;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AnaSayfa extends BasePage{

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement cookiesAccept;

    @FindBy(css = "div .initialComponent-hk7c_9tvgJ8ELzRuGJwC")
    public WebElement searchBar;

    @FindBy(className = "searchBarContent-UfviL0lUukyp5yKZTi4k")
    public WebElement searchBarInput;

    @FindBy(css = ".moria-ProductCard-gyqBb")
    public List<WebElement> urunListesi;


    public void cookiesAccept() {
        waitForPageToLoad();
        waitForElementToBeClickable(cookiesAccept);
        click(cookiesAccept);

    }
    public void sendKeysSearchBar(String value) {
        waitForPageToLoad();
        click(searchBar);
        sendKeys(searchBarInput, value);

    }

    public  void urunSecimi() {
        waitForPageToLoad();
        waitForElementToBeClickable(searchBar);
        Random random = new Random();
        int index = random.nextInt(urunListesi.size());
        System.out.println("Listelenen ürün sayısı: "+urunListesi.size());
        waitForElementToBeClickable(searchBar);
        click(urunListesi.get(index));


    }
}
