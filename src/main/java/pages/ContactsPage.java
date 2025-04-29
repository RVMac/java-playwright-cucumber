package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactsPage {
    private final Page page;

    private final Locator submitButton;
    private final Locator HeaderPageErrorMessage;

    private final Locator ForenameErrorMessage;
    private final Locator EmailErrorMessage;
    private final Locator FeedbackMessageErrorMessage;

    private final Locator ForenameTextField;
    private final Locator EmailTextField;
    private final Locator MessageTextField;

    private final Locator SendingFeedbackProgressBar;
    private final Locator SuccessFeedbackSendingMessage;

    public ContactsPage(Page page){
        this.page = page;

        submitButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Submit"));
        HeaderPageErrorMessage = page.locator("div.alert.alert-error.ng-scope");

        ForenameErrorMessage = page.locator("#forename-err");
        EmailErrorMessage = page.locator("#email-err");
        FeedbackMessageErrorMessage = page.locator("#message-err");

        ForenameTextField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Forename"));
        EmailTextField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email"));
        MessageTextField = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message"));

        SendingFeedbackProgressBar = page.locator("div.progress.progress-info.wait");
        SuccessFeedbackSendingMessage = page.getByText("Thanks test, we appreciate your feedback");
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void verifyHeaderPageErrorMessage(boolean isDisplayed) {
        if (isDisplayed){
            assertThat(HeaderPageErrorMessage).isVisible();
        } else {
            assertThat(HeaderPageErrorMessage).isHidden();
        }
    }

    public void verifyRequiredFieldsErrorMessages(boolean isDisplayed) {
        if (isDisplayed){
            assertThat(ForenameErrorMessage).isVisible();
            assertThat(EmailErrorMessage).isVisible();
            assertThat(FeedbackMessageErrorMessage).isVisible();
        } else {
            assertThat(ForenameErrorMessage).isHidden();
            assertThat(EmailErrorMessage).isHidden();
            assertThat(FeedbackMessageErrorMessage).isHidden();
        }
    }

    public void filloutRequiredFields(String forename, String email, String message) {
        ForenameTextField.fill(forename);
        EmailTextField.fill(email);
        MessageTextField.fill(message);
    }

    public void verifySuccessfulFeedbackSubmission() {
        SendingFeedbackProgressBar.isHidden();
        SuccessFeedbackSendingMessage.isVisible();
    }
}
