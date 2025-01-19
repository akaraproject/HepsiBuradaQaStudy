Feature: Post isleminden dönen deger ile get islemi yapılır

  @Api
  Scenario: Post isleminden alınan deger ile get isteği atılır
    When Post işleminden dönen petid degeri ile get istegi atılır
    Then Response kontrol edilir

