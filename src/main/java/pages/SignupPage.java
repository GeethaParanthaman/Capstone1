package pages;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Utils;

public class SignupPage extends Utils {
	WebDriverWait wait;

	public SignupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// country selection
	@FindBy(linkText = "United States")
	WebElement countryElement;
	@FindBy(xpath = "//span[text()='Account']")
	WebElement accountLinkElement;
	// to click on create an Account button
	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccount;

	// Signup page elements-FirstName
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstNameElement;
	// Signup page elements-lastName
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastnameElement;
	// Signup page elements-Email
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailtextBox;
	// Signup page elements-Password
	@FindBy(xpath = "//input[@id='fld-p1']")
	WebElement passwordElement;
	// Signup page elements-Confirm Password
	@FindBy(xpath = "//input[@name='reenterPassword']")
	WebElement confirmPasswordElement;
	// Signup page elements-Mobile Number
	@FindBy(xpath = "//input[@id='phone']")
	WebElement mobileNumber;
	// Signup page elements-Account recovery
	@FindBy(xpath = "//input[@id='is-recovery-phone']")
	WebElement accountRecoveryCheckbox;
	// Signup page elements-Create an Account button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement createAccountButtonElement;
	// error without phone
	@FindBy(xpath = "//div[@id='phone-text']")
	WebElement errorwithoutPhone;

	public void contrySelection() {
		wait.until(ExpectedConditions.visibilityOf(countryElement)).click();

	}

	public void signUpProcess() {
		wait.until(ExpectedConditions.visibilityOf(accountLinkElement)).click();

	}

	public void createAccountButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(createAccount)).click();
	}

	// Method to handle signup
	public void signup(Map<String, String> inputData) {
		wait.until(ExpectedConditions.visibilityOf(firstNameElement)).sendKeys(inputData.get("FirstName"));
		wait.until(ExpectedConditions.visibilityOf(lastnameElement)).sendKeys(inputData.get("LastName"));
		wait.until(ExpectedConditions.visibilityOf(emailtextBox)).sendKeys(inputData.get("Email"));
		wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(inputData.get("Password"));
		wait.until(ExpectedConditions.visibilityOf(confirmPasswordElement)).sendKeys(inputData.get("ConfirmPassword"));
		scrollDown();
		wait.until(ExpectedConditions.visibilityOf(mobileNumber)).sendKeys(inputData.get("Mobile"));
		wait.until(ExpectedConditions.visibilityOf(createAccountButtonElement)).click();
	}

	public String errorRelatedtoPhone() {

		return errorwithoutPhone.getText();

	}

	public void signupWithPhoneRecoveryCheckbox(Map<String, String> inputData) {
		wait.until(ExpectedConditions.visibilityOf(firstNameElement)).sendKeys(inputData.get("FirstName"));
		wait.until(ExpectedConditions.visibilityOf(lastnameElement)).sendKeys(inputData.get("LastName"));
		wait.until(ExpectedConditions.visibilityOf(emailtextBox)).sendKeys(inputData.get("Email"));
		wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(inputData.get("Password"));
		wait.until(ExpectedConditions.visibilityOf(confirmPasswordElement)).sendKeys(inputData.get("ConfirmPassword"));
		scrollDown();
		wait.until(ExpectedConditions.visibilityOf(mobileNumber)).sendKeys(inputData.get("Mobile"));
		wait.until(ExpectedConditions.visibilityOf(accountRecoveryCheckbox)).click();
		wait.until(ExpectedConditions.visibilityOf(createAccountButtonElement)).click();
	}

}
