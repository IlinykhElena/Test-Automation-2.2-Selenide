import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingDateTest {

    @Test
    void shouldChooseDateToday() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(0).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=\"date\"] .input__sub")
                .shouldHave(Condition.text("Заказ на выбранную дату невозможен"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldChooseDateLessThenPlusThreeDays() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        String planningDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
        $("[placeholder=\"Дата встречи\"]").setValue(planningDate);
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $("[data-test-id=\"date\"] .input__sub")
                .shouldHave(Condition.text("Заказ на выбранную дату невозможен"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }

    @Test
    void shouldChooseDateInThePast() {
        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Москва");
        $("[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(Keys.DELETE);
        $("[placeholder=\"Дата встречи\"]").setValue("01.01.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Иван Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+78945612307");
        $("[data-test-id=\"agreement\"] .checkbox__box").click();
        $(byText("Забронировать")).click();
        $(byText("Заказ на выбранную дату невозможен")).should(visible);
    }

}
