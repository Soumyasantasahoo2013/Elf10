package com.actitime.objectreposiretery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {
	
	@FindBy(id="container_tasks")
	private WebElement taskTab;
	
	@FindBy(id="logoutLink")
	private WebElement lgoutlink;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickTaskTab() {
		taskTab.click();
	}
	public void clickLogoutLink() {
		lgoutlink.click();
	}

}
