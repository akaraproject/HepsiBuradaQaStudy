package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UrunDetay {
    pages.UrunDetay urunDetay = new pages.UrunDetay();
    @When("Degerlendirmeler tabinden en yeni değerlendirmeler secilir")
    public void enYeniDegerlendirmelerSecilir() {

        urunDetay.degerlendirmelerTabaGec();
        urunDetay.siralaDropDowndanSec();

    }

    @When("Değerlendirmelerden birine thumbsUp secilir")
    public void thumsUpSecilir() {

        urunDetay.thumbsUpSec();

    }

    @When("Teşekkür Ederiz yazısı görülür")
    public void tesekkurMesaji() {

        urunDetay.tesekkurMesaji();

    }

    @Then("Diğer Satıcılar kontrol edilir ve ucuz ürün sepete eklenir")
    public void ucuzUrunSepeteEkle() {

        urunDetay.digerSaticilar();

    }

    @And("Fiyat bilgisi kontrol edilir ve ürün sepete eklenir")
    public void urunFiyatiAlinir() {

        urunDetay.urunFiyatiAlinir();
        urunDetay.sepeteGidilir();

    }



}
