import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingNameTest {

    @Test
    void shouldFillNameInOneWord() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInOneWordLowCase() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("иван");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInOneWordUpperCase() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("ИВАН");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInThreeWordsWithSpaces() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Нижний Новгород");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов Иваныч");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInToMuchWordsWithSpaces() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Нижний Новгород");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов Иваныч но это не точно может быть");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameWithSeveralSpaces() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Нижний Новгород");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("И в а н     И в а н о в     И в а н ы ч");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameFromOnlyOneLetter() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Нижний Новгород");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("И");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInTwoWordsWithDash() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Горно-Алтайск");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван-Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInTwoWordsWithSeveralDashes() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Горно-Алтайск");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("И-в-а-н---И-в-а-н-о-в");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameInTwoWordsWithSlash() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Горно-Алтайск");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван/Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", $("[data-test-id=\"name\"] .input__sub").getText().trim());    }

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
    void shouldFillNameWithSpacesAndDashes() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Ростов-на-Дону");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("И-в а-н И-в а-н о-в");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldFillNameWithNumbers() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("7Иван 125 Иванов7");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", $("[data-test-id=\"name\"] .input__sub").getText().trim());
    }

    @Test
    void shouldNameWithLatinLetters() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Ivan Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", $("[data-test-id=\"name\"] .input__sub").getText().trim());
    }

    @Test
    void shouldNameWithSymbols() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("И,в?ан Ива&нов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.", $("[data-test-id=\"name\"] .input__sub").getText().trim());
    }

    @Test
    void shouldNameBeEmpty() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Поле обязательно для заполнения", $("[data-test-id=\"name\"] .input__sub").getText().trim());
    }
}

