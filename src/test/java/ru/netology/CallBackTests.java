package ru.netology;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CallBackTests {

    private FellowOne dummy;
    TrueCity tryMe = new TrueCity();
    Faker ghostOne = new Faker(new Locale("RU"));

    static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    // проверяем,входит ли сгенерированный город в перечень административных субъектов рф.
    public String cityPickUp() {
        String testedCity = ghostOne.address().city();
        while (!tryMe.testIt(testedCity)) {
            testedCity = ghostOne.address().city();
        }
        return testedCity;
    }

    @BeforeEach
    public void setUP() {
        open("http://localhost:9999");
        String firstName = ghostOne.name().firstName().replaceAll("ё", "е");
        String lastName = ghostOne.name().lastName().replaceAll("ё", "е");
        String fullName = firstName + " " + lastName;
        String phone = "+" + ghostOne.phoneNumber().phoneNumber().toString().replaceAll("\\D", "");
        String oldDate = generateDate(ghostOne.random().nextInt(5, 8));
        String newDate = generateDate(ghostOne.random().nextInt(9, 13));
        dummy = new FellowOne(
                fullName,
                phone,
                oldDate,
                newDate,
                cityPickUp());
    }

    @Test
    public void shouldWorkHappyPath() {
        $("[data-test-id=\"city\"] .input__control").setValue(dummy.getNativeCity());
        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getOldDate());
        $("[data-test-id=\"name\"] .input__control").setValue(dummy.getFullName());
        $("[data-test-id=\"phone\"] .input__control").setValue(dummy.getPhone());
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(".form-field .button__content").click();
        $("[data-test-id=\"success-notification\"] .notification__title").should(visible, Duration.ofSeconds(5));
        $("[data-test-id=\"success-notification\"] .notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + dummy.getOldDate()), Duration.ofSeconds(5));

        $("[data-test-id=\"date\"] .input__control").doubleClick().sendKeys(dummy.getNewDate());
        $(".form-field .button__content").click();
        $("[data-test-id=\"replan-notification\"] button").click();
        $("[data-test-id=\"success-notification\"] .notification__title").should(visible, Duration.ofSeconds(5));
        $("[data-test-id=\"success-notification\"] .notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + dummy.getNewDate()), Duration.ofSeconds(5));

    }


}
