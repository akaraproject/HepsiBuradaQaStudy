package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sepet extends BasePage {
    UrunDetay urunDetay = new UrunDetay();
    @FindBy(className = "product_price_uXU6Q")
    public WebElement sepettekiFiyat;

    public void sepettekiFiyat() {
        waitForPageToLoad();
        Double urunFiyatiDouble = UrunDetay.urunFiyatiDouble;
        waitForElementToBeVisible(sepettekiFiyat);
        String sepettekiFiyati = sepettekiFiyat.getText().replace(".", "").replace(",", ".");
        Double sepettekiFiyatiDouble = Double.valueOf(sepettekiFiyati.substring(0, sepettekiFiyati.length()-3));

        if (!sepettekiFiyatiDouble.equals(urunFiyatiDouble)) {

            Assert.fail("Fİyatlar eşit değil!"+sepettekiFiyatiDouble+" "+urunFiyatiDouble);
        }System.out.println("Karşılaştırma başarılı  "+sepettekiFiyatiDouble+"  "+urunFiyatiDouble );

    }

}
