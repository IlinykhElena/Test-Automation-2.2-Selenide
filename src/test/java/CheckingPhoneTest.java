import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingPhoneTest {
    @Test
    void shouldFillPhoneFromTenNumbers() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+7894561230");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromTwelveNumbers() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+789456123078");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromElevenNumbersWithoutPlus() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromElevenNumbersWithSeveralPluses() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612+307+");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromElevenNumbersWithAnotherSymbols() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+7-894-561-2307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromElevenNumbersWithSpaces() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+7 894 561 2307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillPhoneFromElevenNumbersWithLetters() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("plus78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }
}


