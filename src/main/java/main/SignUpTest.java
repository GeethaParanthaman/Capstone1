package main;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.SignupPage;
import utils.Utils;

public class SignUpTest extends Utils {
	SignupPage signUpObject;
	
	
	@BeforeSuite
	public void browserLaunch()
	{
		browserIntialization();
		urlBrokenVerification();

	}
	@Test
	public void SignUp()
	{
		signUpObject=new SignupPage(driver);
		
		signUpObject.contrySelection();
		signUpObject.signUpProcess();
		signUpObject.createAccountButtonClick();
		
		
		
	}
	@Test
	public void excelValues()
	{
		// Path to the Excel file and sheet name
        //String filePath = "/src/test/resources/signup_data.xlsx";
		String filePath = getClass().getClassLoader().getResource("signup_data.xlsx").getPath();
        String sheetName = "Sheet1";

		excelUtils(filePath, sheetName);
	}
	
	@Test
    public void testSignupInvalidPhone() {
        // Get test data for the specific case
        Map<String, String> inputData = getRowData("testSignupInvalidPhone");
        signUpObject.signup(inputData);
       // browserRefresh();
        signUpObject.errorRelatedtoPhone();
        
        
        //without phone->
        
    }

    @Test
    public void validSignupInputswithPhone() {
        // Get test data for the specific case
    	 browserRefresh();
        Map<String, String> inputData = getRowData("validSignupInputswithPhone");
        signUpObject.signup(inputData);
       
    }
    
	@Test
	public void testWithWeakPassword()
	{
		 // Get test data for the specific case
		 browserRefresh();
        Map<String, String> inputData = getRowData("testWithWeakPassword");
        signUpObject.signup(inputData);
       
	}
@Test
public void testwithDoNotMatchPassword()
{
	 // Get test data for the specific case
	 browserRefresh();
    Map<String, String> inputData = getRowData("testwithDoNotMatchPassword");
    signUpObject.signup(inputData);
    

}
@Test
public void testWithoutFields()
{
	// Get test data for the specific case
	browserRefresh();
    Map<String, String> inputData = getRowData("testWithoutFields");
    signUpObject.signup(inputData);
    
}
@Test
public void testWithoutFirstName()
{
	  browserRefresh();
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testWithoutFirstName");
    signUpObject.signup(inputData);
  
	
}
@Test
public void testWithoutLastName()
{
	  browserRefresh();
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testWithoutLastName");
    signUpObject.signup(inputData);
    
}
@Test
public void testSignupWithoutEmail() {
	  browserRefresh();
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testSignupWithoutEmail");
    signUpObject.signup(inputData);
    
}
@Test
public void testSignupWithoutPassword()
{
	  browserRefresh();
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testSignupWithoutPassword");
    signUpObject.signup(inputData);
   
}
@Test
public void testsignupWithPhoneRecovery()
{
	  browserRefresh();
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testsignupWithPhoneRecovery");
    signUpObject.signupWithPhoneRecoveryCheckbox(inputData);
    
   

}
@Test
public void testsignupWithoutPhoneRecovery()
{
	// Get test data for the specific case
    Map<String, String> inputData = getRowData("testsignupWithoutPhoneRecovery");
    signUpObject.signup(inputData);
  
}
	@AfterSuite
	public void browserClose()
	{
		
	        //if (driver != null) {
	           // driver.quit();
	        //}
	        closeWorkbook();
	}

}
