package steps;

import io.cucumber.java.en.When;

public class Sepet {
    pages.Sepet sepet= new pages.Sepet();
    @When("Ürünün liste fiyetı ile sepettki fiyatı karşılaştırılır")
    public void fiyatlarKarsilastilir(){
        sepet.sepettekiFiyat();
    }

}
