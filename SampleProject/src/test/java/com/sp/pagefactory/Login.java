package com.sp.pagefactory;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.sp.datainitialization.DataInt;

public class Login extends SPBase{
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/form[1]/table/tbody/tr/td[1]/input")
	public WebElement emailid	;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/form[1]/table/tbody/tr/td[2]/input")
	public WebElement password;
	
	@FindBy(how = How.XPATH, using = "//td[3]/input")
	public WebElement loginbutton;     
	
	
	public void accountlogin(DataInt dataInt) throws Exception {
		try {
			Thread.sleep(6000);
			emailid.sendKeys(dataInt.getUsername());
			Thread.sleep(1000);
			password.sendKeys(dataInt.getUserpassword());
			Thread.sleep(2000);
			loginbutton.click();
	
			
		} catch (Exception e) {
			excep = e.toString();
			Assert.fail(excep);

		}
	}	
	
	
}
