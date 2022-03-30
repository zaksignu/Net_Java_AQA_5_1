package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTests {

    private FellowOne dummy;

    @BeforeAll
    private static void startUp(){
        TrueCity tryMe = new TrueCity();
        boolean ty = tryMe.testIt("a");
     //   List<String> result = Files.lines(Paths.get("Main.txt"), StandardCharsets.UTF_8).collect(Collectors.toList());
     //   System.out.println();
//        public Date future(int atMost, TimeUnit unit) {
//            Date now = new Date();
//            Date aBitLaterThanNow = new Date(now.getTime() + 100000);
//            return future(atMost, unit, aBitLaterThanNow);
//        }


        //dummy()
    //    Faker ghostOne = new Faker(new Locale("RU"));
//        String firstName = dummy.name().firstName(); // Emory
//        String lastName = dummy.name().lastName(); // Barton
//        String telephone = dummy.phoneNumber().toString();
//        String cardDate = generateDate(6);

    }

    static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    @BeforeEach
    public void setUP() {
        open("http://localhost:9999");
      // Date now =  LocalDate.now();
     //   Date aBitLaterThanNow = now.

        Faker ghostOne = new Faker(new Locale("RU"));
        //dummy = new

        //   now = ghostOne.date().between(now.)
         dummy = new FellowOne(
                ghostOne.name().firstName()+" "+ghostOne.name().lastName(),
                "+"+ghostOne.phoneNumber().phoneNumber().toString().replaceAll("\\D", ""),
                 generateDate(ghostOne.random().nextInt(5,8)),
                 generateDate(ghostOne.random().nextInt(9,13)),
                     ghostOne.address().city());
        System.out.println();
    }

    @Test
    public void shouldWorkHappyPath() {
        $("[data-test-id=\"city\"] .input__control").setValue(dummy.getNativeCity());
        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getOldDate());
       $("[data-test-id=\"name\"] .input__control").setValue(dummy.getFullName());
        $("[data-test-id=\"phone\"] .input__control").setValue(dummy.getPhone());
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".form-field .button__content").click();



        $("[data-test-id=\"notification\"] .notification__title").should(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getNewDate());
        $(".form-field .button__content").click();
        $("[data-test-id='replan-notification'] .notification__content .button").click();
              //  .shouldHave(Condition.text("Встреча успешно забронирована на " + dummy.getOldDate()), Duration.ofSeconds(15));
        $("[class='notification__content']").shouldHave(Condition.text("Встреча успешно забронирована на " + dummy.getNewDate()), Duration.ofSeconds(15));
    }
    @Test
    public void shouldWorkHappyPath2() {
        $("[data-test-id=\"city\"] .input__control").setValue(dummy.getNativeCity());
        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getOldDate());
        $("[data-test-id=\"name\"] .input__control").setValue(dummy.getFullName());
        $("[data-test-id=\"phone\"] .input__control").setValue(dummy.getPhone());
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("[data-test-id=\"notification\"] .notification__title").should(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getNewDate());
        $(".form-field .button__content").click();
        $("[class='notification__content']").shouldHave(Condition.text("Встреча успешно забронирована на " + dummy.getOldDate()), Duration.ofSeconds(15));
    }


}
