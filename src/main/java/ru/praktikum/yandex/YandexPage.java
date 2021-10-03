package ru.praktikum.yandex;

import static com.codeborne.selenide.Selenide.*;

public class YandexPage{
   public  YandexPage(String nameOfTitle){
        setNameOfTitle(nameOfTitle);
    }
   private String nameOfTitle;
   private String urlOfThePage;

   private void setNameOfTitle(String nameOfTitle){
       this.nameOfTitle=nameOfTitle;
   }
   public void goToThePage(){
       urlOfThePage= switchTo().window(nameOfTitle).getCurrentUrl();
   }
   public void outFromThePage(){
       closeWindow();
   }
   public String getUrl(){
        return urlOfThePage;
   }

}
