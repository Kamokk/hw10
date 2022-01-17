package yarieva.pages;

import com.codeborne.selenide.SelenideElement;
import yarieva.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationsPage {
    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive"),
            emailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesCheckBox = $("#hobbiesWrapper"),
            pictureButton = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateDropDownList = $("#state"),
            cityDropDownList = $("#city"),
            submitButton = $("#submit");

    public CalendarComponent calendar = new CalendarComponent();

    // actions
    public RegistrationsPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }


    public RegistrationsPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }


    public RegistrationsPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationsPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationsPage choseGender(String gender) {
        genderRadioButton.$(byText(gender)).click();
        return this;
    }

    public RegistrationsPage typePhoneNumber(String phone) {
        phoneNumberInput.setValue(phone);
        return this;
    }

    public RegistrationsPage chooseDateOfBirth(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationsPage chooseSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationsPage chooseHobbies(String hobbies) {
        hobbiesCheckBox.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationsPage uploadPicture(String picture) {
        pictureButton.uploadFile(new File(picture));
        return this;
    }

    public RegistrationsPage typeCurrentAddress(String streetAddress) {

        currentAddress.setValue(streetAddress);
        return this;
    }

    public RegistrationsPage chooseState(String state) {
        stateDropDownList.click();
        $("#stateCity-wrapper").$(byText((state))).click();
        return this;
    }

    public RegistrationsPage chooseCity(String city) {
        cityDropDownList.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
