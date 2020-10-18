package pwmMFOnlineLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PWMMFOnlineLocators {

	WebDriver driver = null;

	public PWMMFOnlineLocators(WebDriver driver) {
		this.driver = driver;
	}

	By closeMainPopup = By.className("popup-close");

	public WebElement getClosePopup() {
		return driver.findElement(closeMainPopup);
	}

	By clickLoginMenu = By.id("webloginMenu");

	public WebElement getClickLoginMenu() {
		return driver.findElement(clickLoginMenu);
	}

	By username = By.id("txtusername");

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	By password = By.id("txtpassword");

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	By loginButton = By.id("loginbutton");

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

	By familyHeadDropdown = By.xpath("//*[contains(text(),'Showing Data For')]/following-sibling::div[2]");

	public WebElement getFamilyHeadDropdown() {
		return driver.findElement(familyHeadDropdown);
	}

	By familyDropdownSearch = By.xpath("//input[@type='search']");

	public WebElement getFamilyDropdownSearch() {
		return driver.findElement(familyDropdownSearch);
	}

	By mFOnline = By.xpath("//*[text()='MF Online']");

	public WebElement getMFOnlineButton() {
		return driver.findElement(mFOnline);
	}

	By buyNew = By.xpath("//button/*[text()='Buy New']");

	public WebElement getBuyNew() {
		return driver.findElement(buyNew);
	}

	By addFund = By.xpath("//*[text()='Add Fund']");

	public WebElement getAddFundButton() {
		return driver.findElement(addFund);
	}

	By getLumpsumButton = By.xpath("//*[text()='Lumpsum']");

	public WebElement getLumpsumButton() {
		return driver.findElement(getLumpsumButton);
	}

	By mFHolding = By.xpath("//button/*[text()='MF Holdings']");

	public WebElement getMFHoldingMenu() {
		return driver.findElement(mFHolding);
	}

	// MF Holding Scheme


	public List<WebElement> getMFHoldingScheme() {
		return driver.findElements(
				By.xpath("//table[contains(@id,'tblMFHold')]/tbody/descendant::td[contains(@id,'MFScheme')]"));
	}

	// MF Holding Folios
	

	public List<WebElement> getHoldingFolio() {
		return driver
				.findElements(By.xpath("//table[contains(@id,'tblMFHold')]/tbody/descendant::td[contains(@id,'MFFolio')]"));
	}

	By amountTextbox = By.xpath("//*[@placeholder='Enter Amount*']");

	public WebElement getAmountTextbox() {
		return driver.findElement(amountTextbox);
	}

	By folioColumn = By.xpath("//*[text()='Folio']");

	public WebElement getFolioColumn() {
		return driver.findElement(folioColumn);
	}

	By particularByMoreLink(String schemName, String folioNumber) {
		return By.xpath("//table/descendant::td[contains(text(),'" + schemName
				+ "')]/following-sibling::td[contains(text(),'" + folioNumber
				+ "')]/following-sibling::td[contains(@id,'MFAction')]/ul/li/a[text()='Buy More']");
	}
	
	public WebElement particularBuyMoreLink(String schemName, String folioNumber) {
		return driver.findElement(particularByMoreLink(schemName, folioNumber));
	}
	
	By logoutLink = By.xpath("//*[text()='Help']/ancestor::li/following-sibling::li/descendant::*[contains(text(),'Logout')]");
	
	public WebElement getLogoutLink() {
		return driver.findElement(logoutLink);
	}

}
