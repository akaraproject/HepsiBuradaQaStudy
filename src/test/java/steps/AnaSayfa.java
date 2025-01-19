package steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.BasePage;


public class AnaSayfa {
    pages.AnaSayfa anaSayfa= new pages.AnaSayfa();
    @When("Arama cubuğundan Stanley aratılır.")
    public void aramaCubugu() {
        anaSayfa.sendKeysSearchBar("Stanley"+ Keys.ENTER);
    }

    @When("Listelenen ürünlerden rastgele seçilen ürünün detayina gidilir")
    public void randomUrunSecimi() {
        anaSayfa.urunSecimi();
        anaSayfa.cookiesAccept();
    }

}
