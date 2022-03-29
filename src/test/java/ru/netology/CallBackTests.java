package ru.netology;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallBackTests {



    @BeforeAll
    public static void startUp(){

        Faker dummy = new Faker(new Locale("RU"));
        String firstName = dummy.name().firstName(); // Emory
        String lastName = dummy.name().lastName(); // Barton
        String telephone = dummy.phoneNumber().toString();
        String cardDate = generateDate(6);



    }

    static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    @BeforeEach
    public void setUP() {
//        open("http://localhost:9999");
    }

    @Test
    public void shouldWorkHappyPath() {
        String planningDate = generateDate(3);
//        $("[data-test-id=\"city\"] .input__control").setValue("Петрозаводск");
//        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(planningDate);
//        $("[data-test-id=\"name\"] .input__control").setValue("Пупкин Василий");
//        $("[data-test-id=\"phone\"] .input__control").setValue("+79123456789");
//        $("[data-test-id=\"agreement\"] .checkbox__box").click();
//        $(".form-field .button__content").click();
//        $("[data-test-id=\"notification\"] .notification__title").should(Condition.visible, Duration.ofSeconds(15));
//        $("[class='notification__content']").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15));
    }



}
