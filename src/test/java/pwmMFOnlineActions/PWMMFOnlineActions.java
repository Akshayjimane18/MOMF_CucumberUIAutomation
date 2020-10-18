package pwmMFOnlineActions;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common_Framework_Functions.JavaScriptMouseOperations;
import common_Framework_Functions.MouseActions;
import common_Framework_Functions.PauseExecutionFor;
import common_Framework_Functions.WebButton;
import common_Framework_Functions.WebTextBox;
import pwmMFOnlineLocators.PWMMFOnlineLocators;

public class PWMMFOnlineActions {

	WebDriver driver;
	PWMMFOnlineLocators loc;
	WebElement elem;
	

	public PWMMFOnlineActions(WebDriver driver) {
		
		this.driver = driver;
		loc = new PWMMFOnlineLocators(driver);
	}

	public void closeThePopup() {
		elem = loc.getClosePopup();

		if (elem != null) {
			if (elem.isEnabled()) {
				elem.click();
			}
		}

	}

	public void clickLoginMenu() {
		elem = loc.getClickLoginMenu();

		if (elem != null) {
			if (elem.isEnabled()) {
				elem.click();
			}
		}
	}

	public void enterUsername(String username) {
		elem = loc.getUsername();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebTextBox.sendInput(elem, username);
			}
		}
	}

	public void enterPassword(String password) {
		elem = loc.getPassword();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebTextBox.sendInput(elem, password);
			}
		}
	}

	public void clickLoginButton() {
		elem = loc.getLoginButton();

		if (elem != null) {
			if (elem.isEnabled()) {
				elem.click();
			}
		}
	}

	public void clickFamilyMemberDropdown() {
		elem = loc.getFamilyHeadDropdown();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebButton.click(elem);
			}
		}
	}

	public void searchFamilyMemberName(String familyMemberName) {
		elem = loc.getFamilyDropdownSearch();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebTextBox.sendInput(elem, familyMemberName);
			}
		}
	}

	public void hitEnterButtonInSearchBox(Keys keyType) {
		elem = loc.getFamilyDropdownSearch();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebTextBox.sendInput(elem, keyType);
			}
		}
	}

	public void clickMFOnlineButton() {
		elem = loc.getMFOnlineButton();

		if (elem != null) {
			if (elem.isEnabled()) {
				JavaScriptMouseOperations.click(driver, elem);
			}
		}
	}

	public void clickMFHoldingMenu() {
		elem = loc.getMFHoldingMenu();

		if (elem != null) {
			if (elem.isEnabled()) {
				WebButton.click(elem);
			}
		}
	}

	public void clickBuyMoreLink(String schemName, String folioNumber) throws InterruptedException {

		List<WebElement> holdingSchemes = loc.getMFHoldingScheme();
		List<WebElement> holdingFolios = loc.getHoldingFolio();

		for (WebElement schemeNames : holdingSchemes) {

			String schemeString = schemeNames.getText();
			for (WebElement folios : holdingFolios) {

				String folioString = folios.getText();

				if (schemeString.contains(schemName)) {

					if ((folioString.contains(folioNumber))) {

						Thread.sleep(3000);
						JavaScriptMouseOperations.click(driver, loc.particularBuyMoreLink(schemName, folioNumber));
						break;
					}

				}
			}

		}

	}

	public void clickOnLoginLink() {

		elem = loc.getLogoutLink();

		if (elem != null) {
			if (elem.isEnabled()) {
				JavaScriptMouseOperations.click(driver, elem);
			}
		}
	}

}
