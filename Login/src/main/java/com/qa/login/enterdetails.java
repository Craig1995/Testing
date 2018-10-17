package com.qa.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class enterdetails {
@FindBy (name = "username")
private WebElement usernameBox;

@FindBy (name = "password")
private WebElement passwordBox;

@FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
private WebElement searchText;


public void getSearched(String text1, String text2) {
	usernameBox.sendKeys(text1);
	passwordBox.sendKeys(text2);
	
	passwordBox.submit();
	}

public WebElement searchText() {
	return searchText;
}
}
