import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingCityTest {

    @Test
    void shouldFillAllFieldsCorrectWithCityInOneWord() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectWithCityInOneWordLowCase() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectWithCityInOneWordUpperCase() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("МОСКВА");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectWithCityInTwoWordsWithSpace() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Нижний Новгород");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectWithCityInTwoWordsWithDash() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Горно-Алтайск");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectWithCityInThreeWordsWithTwoDashes() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Ростов-на-Дону");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillAllFieldsCorrectButCityInFourWordsWithThreeDashes() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Ростов-на-глубоком-Дону");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillAllFieldsCorrectButCityInThreeWordsWithTwoSpaces() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Ростов на Дону");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillAllFieldsCorrectButCityInOneWordButNotFromList() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Сочи");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillAllFieldsCorrectButCityWithNumbers() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва12");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillAllFieldsCorrectButCityWithLatinLetters() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Moskwa");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldFillAllFieldsCorrectButCityWithSymbols() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("/Мо?ск.ва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Доставка в выбранный город недоступна", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }
}
