package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.tests.components.CalendarComponent;
import org.junit.jupiter.api.Test;
import guru.qa.tests.page.RegistrationPage;

public class PracticeFormTests extends BaseTest {
    static Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            name = firstName + " " + lastName,
            email = faker.internet().emailAddress(),
            gender = "Female",
            phoneNumber = faker.numerify("##########"),
            month = "September",
            year = "1995",
            day = "23",
            date = day + " " + month + "," + year,
            subject = "English",
            file = "cat.jpeg",
            address = "Russia",
            state = "NCR",
            city = "Delhi",
            stateAndCity = state + " " + city;

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent calendar = new CalendarComponent();

    @Test
    void submitFormTest() {
        registrationPage.openPage("https://demoqa.com/automation-practice-form");
        registrationPage.typeName(firstName, lastName);
        registrationPage.typeEmail(email);
        registrationPage.chooseGender(gender);
        registrationPage.typePhoneNumber(phoneNumber);
        calendar.selectDate(month, year, day);
        registrationPage.typeSubject(subject);
        registrationPage.checkHobby(Hobbies.READING);
        registrationPage.checkHobby(Hobbies.MUSIC);
        registrationPage.inputImage(file);
        registrationPage.typeAddress(address, state, city);
        registrationPage.checkResults(name, email, gender, phoneNumber, date, subject, Hobbies.READING.name + ", " + Hobbies.MUSIC.name, file, address, stateAndCity);

    }
}
