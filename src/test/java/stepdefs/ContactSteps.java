package stepdefs;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactsPage;
import utils.PlaywrightFactory;

import java.util.List;
import java.util.Map;

public class ContactSteps {
    Page page = PlaywrightFactory.getPage();
    ContactsPage contactsPage = new ContactsPage(page);

    @When("I submit the feedback")
    public void whenISubmitTheFeedback(){
        contactsPage.clickSubmit();
    }

    @When("I populate the mandatory fields")
    public void iPopulateTheMandatoryFields(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps();

        for (Map<String, String> credential : credentials) {
            String Forename = credential.get("Forename");
            String Email = credential.get("Email");
            String Message = credential.get("Message");

            contactsPage.filloutRequiredFields(Forename, Email, Message);
        }
    }

    @Then("I can see header page error messages")
    public void i_can_see_header_page_error_messages(){
        contactsPage.verifyHeaderPageErrorMessage(true);
    }

    @Then("I can see error messages from required fields")
    public void iCanSeeErrorMessagesFromRequiredFields() {
        contactsPage.verifyRequiredFieldsErrorMessages(true  );
    }

    @Then("header page error message will be removed")
    public void headerPageErrorMessageWillBeRemoved() {
        contactsPage.verifyHeaderPageErrorMessage(false);
    }

    @Then("error messages from required fields will be removed")
    public void errorMessagesFromRequiredFieldsWillBeRemoved() {
        contactsPage.verifyRequiredFieldsErrorMessages(false);
    }

    @Then("the feedback is submitted successfully")
    public void theFeedbackIsSubmittedSuccessfully() {
        contactsPage.verifySuccessfulFeedbackSubmission();
    }
}
