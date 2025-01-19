Feature: Ürün arama, değerledirme ve karşılaştıma işlemleri

  @UI @Senaryo1
  Scenario: Ürün Degerlendirme
    When Arama cubuğundan Stanley aratılır.
    When Listelenen ürünlerden rastgele seçilen ürünün detayina gidilir
    When Degerlendirmeler tabinden en yeni değerlendirmeler secilir
    And Değerlendirmelerden birine thumbsUp secilir
    Then Teşekkür Ederiz yazısı görülür


  @UI @Senaryo2
  Scenario: Ürün fiyatı karşılaştırması ve uygun fiyatlı ürünün sepete eklenmesi
    When Arama cubuğundan Stanley aratılır.
    When Listelenen ürünlerden rastgele seçilen ürünün detayina gidilir
    Then Diğer Satıcılar kontrol edilir ve ucuz ürün sepete eklenir

  @UI @Senaryo3
  Scenario: Ürün liste fiyatı ve sepet fiyatı karşılaştırması
    When Arama cubuğundan Stanley aratılır.
    When Listelenen ürünlerden rastgele seçilen ürünün detayina gidilir
    And Fiyat bilgisi kontrol edilir ve ürün sepete eklenir
    Then Ürünün liste fiyetı ile sepettki fiyatı karşılaştırılır


