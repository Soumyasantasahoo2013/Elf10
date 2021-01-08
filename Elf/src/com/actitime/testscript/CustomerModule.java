package com.actitime.testscript;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.objectreposiretery.EnterTimeTrackPage;
import com.actitime.objectreposiretery.TaskListPage;

@Listeners(com.actitime.generics.Listenerimplementation.class)
public class CustomerModule extends BaseClass{
	
@Test
public void testCreateCustomer() throws IOException, InterruptedException {
	
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.clickTaskTab();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getAddNewCustomerMenu().click();
	String customerName = f.getExcelValue("CreateCustomer", 1, 2);
	String customerDescp = f.getExcelValue("CreateCustomer", 1, 3);
	t.getEnterCustNametbx().sendKeys(customerName);
	t.getEnterCustDesctbx().sendKeys(customerDescp);
	t.getSelectDropDown().click();
	t.getOurcompanyName().click();
	t.getCreatecustomerbtn().click();
	//Thread.sleep(5000);
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomerCreated(), customerName));
	String actualCustomer = t.getActualCustomerCreated().getText();
	Assert.assertEquals(customerName, actualCustomer);
}

}
