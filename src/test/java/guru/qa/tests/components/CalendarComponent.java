package guru.qa.tests.components;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void selectDate(String month, String year, String day){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(".react-datepicker__day--0" + day).click();
    }
}
