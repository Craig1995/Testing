package com.qa.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createUser {
	@FindBy (name = "username")
	private WebElement createUsername;

	@FindBy (name = "password")
	private WebElement createPassword;
		

public void createUser(String usernameText, String passwordText) {
	createUsername.sendKeys(usernameText);
	createPassword.sendKeys(passwordText);
	
	createPassword.submit();
}


}
