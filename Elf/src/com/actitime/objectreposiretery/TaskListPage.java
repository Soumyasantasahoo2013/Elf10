package com.actitime.objectreposiretery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement addNewCustomerMenu;
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement enterCustNametbx;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement enterCustDesctbx;
	
	@FindBy(className="emptySelection")
	private WebElement selectDropDown;
	
	@FindBy(xpath="//div[.='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourcompanyName;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createcustomerbtn;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement ActualCustomerCreated;
	
	public WebElement getActualCustomerCreated() {
		return ActualCustomerCreated;
	}

	public TaskListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getAddNewCustomerMenu() {
		return addNewCustomerMenu;
	}

	public WebElement getEnterCustNametbx() {
		return enterCustNametbx;
	}

	public WebElement getEnterCustDesctbx() {
		return enterCustDesctbx;
	}

	public WebElement getSelectDropDown() {
		return selectDropDown;
	}

	public WebElement getOurcompanyName() {
		return ourcompanyName;
	}

	public WebElement getCreatecustomerbtn() {
		return createcustomerbtn;
	}

}
