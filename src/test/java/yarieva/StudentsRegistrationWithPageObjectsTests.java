package yarieva;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class StudentsRegistrationWithPageObjectsTests extends TestBase {


    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("en"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String phone = faker.phoneNumber().subscriberNumber(10);

        registrationsPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .choseGender("Female")
                .typePhoneNumber(phone)
                .chooseDateOfBirth("10", "September", "2007")
                .chooseSubject("Hindi")
                .chooseHobbies("Music")
                .uploadPicture("src/test/resources/img/JoyCorp.jpg")
                .typeCurrentAddress(streetAddress)
                .chooseState("Haryana")
                .chooseCity("Karnal")
                .clickSubmit();


        //assert
        registrationsPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", email)
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", phone)
                .checkResultsValue("Date of Birth", "10 September,2007")
                .checkResultsValue("Subjects", "Hindi")
                .checkResultsValue("Hobbies", "Music")
                .checkResultsValue("Picture", "JoyCorp.jpg")
                .checkResultsValue("Address", streetAddress)
                .checkResultsValue("State and City", "Haryana" + " " + "Karnal");

    }
}