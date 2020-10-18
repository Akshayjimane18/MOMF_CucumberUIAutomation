package stepDefinations;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import common_Framework_Functions.Alerts;
import common_Framework_Functions.GetPropertyValue;
import common_Framework_Functions.PauseExecutionFor;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pwmMFOnlineActions.PWMMFOnlineActions;
import pwmMFOnlineLocators.PWMMFOnlineLocators;

@RunWith(Cucumber.class)
public class MFOnlineStepDefination {

	WebDriver driver = Hooks.driver;
	PWMMFOnlineActions actions = new PWMMFOnlineActions(driver);
	PWMMFOnlineLocators loc = new PWMMFOnlineLocators(driver);
	SoftAssert assertion = new SoftAssert();
	GetPropertyValue getData = new GetPropertyValue();

	@Given("^User is on myportfolio page$")
	public void user_is_on_myportfolio_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {

			PWMMFOnlineActions actions = new PWMMFOnlineActions(driver);

			File filepath = new File("TestData");
			File fs = new File(filepath, "TestData.properties");
			String getTestFile = fs.getAbsolutePath();
			String username = getData.getPropValues(getTestFile, "username");
			String password = getData.getPropValues(getTestFile, "password");
			actions.clickLoginMenu();
			actions.enterUsername(username);
			actions.enterPassword(password);
			actions.clickLoginButton();
			Alerts.alertClick(driver);
			PauseExecutionFor.ElementToBeVisible(driver, loc.getFamilyHeadDropdown());
			PauseExecutionFor.ElementToBeClickable(driver, loc.getFamilyHeadDropdown());
			assertion.assertTrue(loc.getFamilyHeadDropdown().isDisplayed(),"");
			assertion.assertAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^Family head select his name as \"([^\"]*)\" from dropdown$")
	public void family_head_select_his_name_as_from_dropdown(String familyMemberName) throws Throwable {

		try {

			Thread.sleep(5000);
			actions.clickFamilyMemberDropdown();
			actions.searchFamilyMemberName(familyMemberName);
			actions.hitEnterButtonInSearchBox(Keys.ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	@And("^Click on MF Online button$")
	public void click_on_MF_Online_button() throws Throwable {

		try {
			PauseExecutionFor.ElementToBeVisible(driver, loc.getAddFundButton());
			PauseExecutionFor.ElementToBeClickable(driver, loc.getMFOnlineButton());

			actions.clickMFOnlineButton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^Family head bydefault should display MF Holding page$")
	public void family_head_bydefault_should_display_MF_Holding_page() throws Throwable {

		try {
			PauseExecutionFor.ElementToBeVisible(driver, loc.getBuyNew());
			assertion.assertEquals(loc.getLumpsumButton().isDisplayed(), true);
			assertion.assertAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^MF Holding page table to be display$")
	public void mf_holding_page_table_to_be_display() throws Throwable {
		Thread.sleep(5000);
		actions.clickMFHoldingMenu();
	}

	@And("^User click Buy More link of \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_click_buy_more_link_of_something_and_something(String schemename, String folionumber)
			throws Throwable {

		actions.clickBuyMoreLink(schemename, folionumber);
	}

	@Then("^Enter Amount Textbox should display$")
	public void enter_amount_textbox_should_display() throws Throwable {

		assertion.assertEquals(loc.getAmountTextbox().isEnabled(), true);
		assertion.assertAll();
	}

	@Then("^User got loggout$")
	public void user_got_loggout() throws Throwable {
		actions.clickOnLoginLink();
	}

}
