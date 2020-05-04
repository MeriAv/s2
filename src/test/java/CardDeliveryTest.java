import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=city] input").setValue("Челябинск");
        form.$("[data-test-id=date] input").setValue("10.05.2020");
        form.$("[data-test-id=name] input").setValue("Тестов Тест");
        form.$("[data-test-id=phone] input").setValue("+785365214598");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(withText("Успешно!")).waitUntil(exist, 15000);
        //$(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
