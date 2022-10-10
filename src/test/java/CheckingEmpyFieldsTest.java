import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingEmpyFieldsTest {
    @Test
    void shouldBeWithoutCity() {
        open("http://localhost:9999/");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Поле обязательно для заполнения", $("[data-test-id=\"city\"] .input__sub").getText().trim());
    }

    @Test
    void shouldBeWithoutDate() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Неверно введена дата", $("[data-test-id=\"date\"] .input__sub").getText().trim());
    }

    @Test
    void shouldBeWithoutName() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        assertEquals("Поле обязательно для заполнения", $("[data-test-id=\"name\"] .input__sub").getText().trim());
    }

    @Test
    void shouldBeWithoutPhone() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $(byText("Забронировать")).click();
        assertEquals("Поле обязательно для заполнения", $("[data-test-id=\"phone\"] .input__sub").getText().trim());
    }

    @Test
    void shouldBeWithoutSubmittingAgreement() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[data-test-id=\"date\"] .input__control").setValue("13.10.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $(byText("Забронировать")).click();
        assertEquals("rgba(255, 92, 92, 1)", $("[data-test-id=\"agreement\"] .checkbox__text").getCssValue("color"));
    }
}
