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
    private final SelenideElement
            formTitle = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement resultsTable = $(".table-responsive");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadioButton = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    private final SelenideElement pictureButton = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement stateDropDownList = $("#state");
    private final SelenideElement cityDropDownList = $("#city");
    private final SelenideElement submitButton = $("#submit");
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
