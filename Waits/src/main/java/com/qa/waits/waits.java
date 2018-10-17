package com.qa.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waits {

	@FindBy(id = "quote")
	private WebElement parent;
	
	public WebElement getElement(WebDriver driver) {
		WebElement element = (new WebDriverWait(driver, 20))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"shafeeq\"]/h1")));
	return element;
}
	
}
