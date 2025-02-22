package com.pageobjects.superadminpages.VMS;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utils.Log;

public class VomsOrderApproval1Page1 {

	WebDriver driver = null;
	public VomsOrderApproval1Page1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "voucherType" )
	private WebElement voucherType;
	
	@FindBy(name = "productID" )
	private WebElement productID;
	
	@FindBy(name = "submitApprv1" )
	private WebElement submitApprv1;
	
	@ FindBy(xpath = "//ul/li")
	private WebElement message;
	
	@FindBy(xpath = "//ol/li")
	private WebElement errorMessage;
	
	public boolean isVoucherTypeAvailable(){
		Log.info("Trying to check if Voucher Type drop down available");
		if(voucherType.isDisplayed())
		return true;
		else
			return false;
		}
	
	public void SelectVoucherType(String value){
		Log.info("Trying to Select Voucher Type");
		Select select = new Select(voucherType);
		select.selectByValue(value);
		Log.info("Voucher Type selected  successfully as:"+ value);
		}
	
	public void SelectProductId(String value){
		Log.info("Trying to Select Product ID");
		Select select = new Select(productID);
		select.selectByVisibleText(value);
		Log.info("Product ID selected  successfully as:"+ value);
		}
	
	public boolean availabilityofProduct(String value){
		Log.info("Trying to Select Product");
		List<String> values = new ArrayList<String>();
		String text="";
		Select select = new Select(productID);
		List<WebElement> e= select.getOptions();
		for(WebElement ele : e) {
			text=ele.getText();
			values.add(text);
		}
		boolean flag =values.contains(value);
		if(!flag)
		Log.info("Profile is not available "+ value);
		else {
			Log.info("Profile is available "+value);
		}
		return flag;
	}
	
	public void ClickonSubmit(){
		Log.info("Trying to click on Submit Button");
		submitApprv1.click();
		Log.info("Clicked on Submit Button successfully");
		}
	
	public String getMessage(){
		String Message = null;
		Log.info("Trying to fetch Message");
		try {
		Message = message.getText();
		Log.info("Message fetched successfully as: " + Message);
		} catch (Exception e) {
			Log.info("No Message found");
		}
		return Message;
	}
	
	public String getErrorMessage() {
		String Message = null;
		Log.info("Trying to fetch Error Message");
		try {
		Message = errorMessage.getText();
		Log.info("Error Message fetched successfully as:"+ Message);
		}
		catch (org.openqa.selenium.NoSuchElementException e) {
			Log.info("Error Message Not Found");
		}
		return Message;
	}
}
