package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAl() {
        Configuration.startMaximized = true;
    }
    @Test
    void submitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("First");
        $("#lastName").setValue("Last");
        $("#userEmail").setValue("example@mail.ru");
        $("[for = gender-radio-2]").click();
        $("#userNumber").setValue("8999123456");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").find("[value = '5']").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").find("[value = '1996']").click();
        $(".react-datepicker__day--024").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[for = 'hobbies-checkbox-2']").click();
        $("[for = 'hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("cat.jpeg");
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("First Last"));
        $(".table-responsive").shouldHave(Condition.text("example@mail.ru"));
        $(".table-responsive").shouldHave(Condition.text("Female"));
        $(".table-responsive").shouldHave(Condition.text("8999123456"));
        $(".table-responsive").shouldHave(Condition.text("24 June,1996"));
        $(".table-responsive").shouldHave(Condition.text("English"));
        $(".table-responsive").shouldHave(Condition.text("Reading, Music"));
        $(".table-responsive").shouldHave(Condition.text("cat.jpeg"));
        $(".table-responsive").shouldHave(Condition.text("Russia"));
        $(".table-responsive").shouldHave(Condition.text("NCR Delhi"));

    }
}
