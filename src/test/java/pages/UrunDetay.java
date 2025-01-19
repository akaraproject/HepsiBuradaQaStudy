package pages;

import io.cucumber.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UrunDetay extends BasePage{

    @FindBy(xpath = "//*[@id=\"tab\"]/div[1]/button[2]")
    public WebElement degerlendirmeler;

    @FindBy(className = "arrowUpOrange")
    public WebElement siralaDropdown;

    @FindBy(xpath = "//div[.='En yeni değerlendirme']")
    public WebElement enYeniDegerlendirme;

    @FindBy(css = ".thumbsUp")
    public WebElement thumbsUp;

    @FindBy(css = ".hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca")
    public WebElement tesekkurMesaji;

    @FindBy(xpath = "//*[@id=\"container\"]/div/main/div/div/div[2]/section[1]/div[3]/div[3]/div[2]")
    public WebElement digerSaticilar;

    @FindBy(xpath = "//button[@data-test-id='addToCart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[@data-test-id='price-current-price']")
    public List<WebElement> digerSaticiFiyatlari;

    @FindBy(className = "bWwoI8vknB6COlRVbpRj")
    public WebElement sepettekiUrunFiyati;

    @FindBy(xpath = "//div[@data-test-id='default-price']")
    public WebElement sepettekiUrunFiyati1;

    @FindBy(xpath = "//*[.='Ürüne git']")
    public List<WebElement> uruneGit;

    @FindBy(xpath = "//*[.='Sepete git']")
    public WebElement sepeteGit;

    public static Double urunFiyatiDouble;

    public void degerlendirmelerTabaGec () {
        switchToWindow();
        scrollToElement(degerlendirmeler);
        click(degerlendirmeler);

    }

    public void siralaDropDowndanSec () {
        scrollToElement(siralaDropdown);
        click(siralaDropdown);
        click(enYeniDegerlendirme);
    }

    public void thumbsUpSec() {
        scrollToElement(thumbsUp);
        click(thumbsUp);
    }

    public void tesekkurMesaji() {

        String mesaj = tesekkurMesaji.getText();
        if (!mesaj.equals("Teşekkür Ederiz.")) {
            AssertionError error = new AssertionError("Teşekkür ederiz yazısını göremedim");
        }
        else
            System.out.println(mesaj);
    }

    public void digerSaticilar() {
        switchToWindow();
        waitForPageToLoad();
        waitForElementToBeClickable(sepeteEkle);
        if (!digerSaticiFiyatlari.isEmpty()) {
            Double minFiyat=getPrice(whichActiveElement(sepettekiUrunFiyati,sepettekiUrunFiyati1));
            int index=0;

               for (int i = 0; i < digerSaticiFiyatlari.size(); i++) {

                   if (getPrice(digerSaticiFiyatlari.get(i))<minFiyat) {

                       minFiyat = getPrice(digerSaticiFiyatlari.get(i));
                       index = i;

                   }

               }
               double minListFiyat = getPrice(digerSaticiFiyatlari.get(index));
               if (minListFiyat < getPrice(whichActiveElement(sepettekiUrunFiyati,sepettekiUrunFiyati1))) {
                   scrollToElement(uruneGit.get(index));
                   click(uruneGit.get(index));
                   System.out.println("Diğer satıcılar kısmından  "+ index +" numaralı indexde bulunan satıcının ürünü secildi");
                   scrollToElement(sepeteEkle);
                   click(sepeteEkle);
               }
               else {
                   scrollToElement(sepeteEkle);
                   click(sepeteEkle);
               }

        }
        else{
            scrollToElement(sepeteEkle);
            click(sepeteEkle);
        }


    }

    public void urunFiyatiAlinir(){

        switchToWindow();
        waitForPageToLoad();
        if (isElementPresent(sepettekiUrunFiyati)) {
            urunFiyatiDouble = getPrice(sepettekiUrunFiyati);
            scrollToElement(sepeteEkle);
            click(sepeteEkle);
        } else if (isElementPresent(sepettekiUrunFiyati1)) {

            urunFiyatiDouble = getPrice(sepettekiUrunFiyati1);
            scrollToElement(sepeteEkle);
            click(sepeteEkle);

        }else {System.out.println("Ürün fiyatı bulunamadı");}



    }

    public void sepeteGidilir(){
        waitForElementToBeVisible(sepeteGit);
        click(sepeteGit);
    }

    public Double getPrice(WebElement element){

        String price = element.getText().replace(".", "").replace(",", ".");

        Double doublePrice = Double.valueOf(price.substring(0, price.length()-3));

        System.out.println(doublePrice);

        return doublePrice;

    }

}
