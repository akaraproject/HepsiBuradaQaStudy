
# E-Ticaret Test Otomasyon Projesi

Bu proje, bir e-ticaret sitesi için çeşitli fonksiyonel testlerin otomatikleştirilmesini amaçlayan bir test otomasyon projesidir.
Proje, Java ve Selenium WebDriver kullanılarak geliştirilmiştir ve BDD (Behavior Driven Development) yaklaşımı ile yazılmıştır.
Ayrıca, kullanıcıların ürünleri değerlendirmesi, sepet fiyatı ve ürünün liste fiyatı gibi özelliklerin yanı sıra satıcılar arasındaki
fiyat karşılaştırmalarını ve API testlerini içeren senaryoları kapsamaktadır.

## İçerik

- [Proje Hakkında](#proje-hakkında)
- [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
- [Test Senaryoları](#test-senaryoları)
---

## Proje Hakkında

Bu test otomasyon projesi, e-ticaret sitesinde çeşitli işlevlerin doğruluğunu kontrol etmek amacıyla Selenium WebDriver ile yazılmıştır. Proje, BDD yaklaşımına uygun olarak Gherkin dilinde yazılmış senaryoları içerir ve testlerin anlaşılabilirliğini artırmak için Cucumber framework'ü kullanılmaktadır.

Proje, aşağıdaki test senaryolarını kapsamaktadır:
- **Ürün Değerlendirme:** Kullanıcıların ürünlere yorum yapabilme ve puan verebilme işlevselliği.
- **Sepet Fiyatı:** Sepetteki ürünlerin toplam fiyat hesaplamalarının doğru yapılması.
- **Ürün Liste Fiyatı:** Ürünlerin liste fiyatlarının doğru görüntülenmesi.
- **Fiyat Karşılaştırması:** Aynı ürünü satan farklı satıcılar arasındaki fiyatlar karşılaştırılmalı ve doğru fiyatlar gösterilmelidir.
- **API Testleri:** POST ve GET istekleri ile API doğrulama işlemleri.

## Kullanılan Teknolojiler

- **Java**: Test senaryolarının yazıldığı ana programlama dili.
- **Selenium WebDriver**: Web uygulamalarında test senaryolarının otomatik olarak çalıştırılmasını sağlayan araç.
- **Cucumber**: BDD yaklaşımını kullanarak testlerin yazılmasını sağlayan framework.
- **RestAssured**: API testi için kullanılan Java kütüphanesi.
- **Git**: Versiyon kontrolü için kullanılır.
- **IDE**: Intellij IDEA
  ##Test Senaryoları

## Proje, aşağıdaki senaryoları içermektedir:

- **Ürün Değerlendirme Senaryosu**: Kullanıcıların yaptığı değerlendinin faydalı bulduğunu belirtir.
- **Sepet Fiyatı ve Ürün Liste Fiyatı Karşılaştırma Senaryosu**: Sepetteki ürünün fiyatı ile liste fiyatı karşılaştırılır.
- **Fiyat Karşılaştırması Senaryosu**: Aynı ürünü satan farklı satıcılar arasındaki fiyatlar karşılaştırılmalı ve en ucuz ürün seçilmelidir.
- **Api Test Senaryosu**: Gönderilen post isteğinden alınan değer ile get isteği yollanır.

---

