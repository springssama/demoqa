package guru.qa.tests.page;

import com.codeborne.selenide.Condition;
import guru.qa.tests.Hobbies;
import io.qameta.allure.Step;

import javax.print.attribute.standard.MediaSize;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    @Step("Открыть страницу с формой")
    public RegistrationPage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Ввести имя")
    public RegistrationPage typeName(String firstName, String lastName){
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Ввести почту")
    public RegistrationPage typeEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Выбрать пол")
    public RegistrationPage chooseGender(String gender) {
        $$(".custom-radio").find(Condition.text(gender)).click();
        return this;
    }

    @Step("Ввести номер телефона")
    public RegistrationPage typePhoneNumber(String number) {
        $("#userNumber").setValue(number);
        return this;
    }

    @Step("Выбрать предмет")
    public RegistrationPage typeSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбрать хобби")
    public RegistrationPage checkHobby(Hobbies hobby){
        $$(".custom-checkbox").get(hobby.number).click();
        return this;
    }

    @Step("Загрузить изображение")
    public RegistrationPage inputImage(String image) {
        $("#uploadPicture").uploadFromClasspath(image);
        return this;
    }

    @Step("Ввести адрес")
    public RegistrationPage typeAddress(String address, String state, String city) {
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();
        return this;
    }

    @Step("Проверить результаты")
    public RegistrationPage checkResults(String name, String email, String gender, String phone, String date, String subject, String hobby, String file, String address, String city){
        $(".modal-title").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text(name));
        $(".table-responsive").shouldHave(Condition.text(email));
        $(".table-responsive").shouldHave(Condition.text(gender));
        $(".table-responsive").shouldHave(Condition.text(phone));
        $(".table-responsive").shouldHave(Condition.text(date));
        $(".table-responsive").shouldHave(Condition.text(subject));
        $(".table-responsive").shouldHave(Condition.text(hobby));
        $(".table-responsive").shouldHave(Condition.text(file));
        $(".table-responsive").shouldHave(Condition.text(address));
        $(".table-responsive").shouldHave(Condition.text(city));
        return this;
    }
}
