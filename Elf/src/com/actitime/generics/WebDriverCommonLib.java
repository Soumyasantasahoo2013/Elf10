package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	
	/**
	 * implicit wait for element present in Gui
	 * @param driver
	 */
	
	public void waitForElementInGui(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Explicit wait for element present in Gui
	 * @param driver
	 * @param element
	 */
	public void waitForElementPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * custom wait for element is displayed
	 * @param element
	 */
	public void customWait(WebElement element)
	{
		int i=0;
		while(i<100)
		{
			try {
				element.isDisplayed();
				break;
			}
			catch(Exception e)
			{
				i++;
			}
			
		}
	}
	
	/**
	 * To select the option from the dropdown using index
	 * @param element
	 * @param i
	 */
	public void selectOption(WebElement element, int i)
	{
		Select s=new Select(element);
		s.selectByIndex(i);
	}
	
	public void selectOption(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
}
