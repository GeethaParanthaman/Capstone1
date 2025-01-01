package main;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignupPage;
import utils.Utils;

public class LoginTest extends SignUpTest {
	@BeforeTest
	public void loginFlow() {

		signUpObject = new SignupPage(driver);
		signUpObject.contrySelection();
		signUpObject.signUpProcess();
		signUpObject.createAccountButtonClick();

		
	}

}
