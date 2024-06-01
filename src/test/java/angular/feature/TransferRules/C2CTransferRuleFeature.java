package angular.feature.TransferRules;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;

import angular.classes.LoginRevamp;
import angular.pageobjects.TranferRule.C2CTransferRulePageObject;
import angular.pageobjects.TranferRule.C2SAddModifyDeleteTransferRule;
import jline.internal.Log;

public class C2CTransferRuleFeature extends BaseTest {

	String senderCategory="null", receiverCategory="null", yes = "YES", no = "NO";

	public WebDriver driver;
	WebDriverWait wait;
	LoginRevamp login;
	C2CTransferRulePageObject ccpo;
	C2SAddModifyDeleteTransferRule cspo;
	C2S_AddModifyDelete_TransferRule_Feature csf;

	public C2CTransferRuleFeature(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		login = new LoginRevamp();
		ccpo = new C2CTransferRulePageObject(driver);
		cspo = new C2SAddModifyDeleteTransferRule(driver);
		csf = new C2S_AddModifyDelete_TransferRule_Feature(driver);
	}

	public void c2cTransferValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectDirectTransferAllowed(status);
			ccpo.clickOnControlTransferLevelDD();
			csf.selectValueFromDropDown();
			ccpo.clickOnFixedTransferTransferLevel();
			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}
	
	public void modifyc2cTransferValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectDirectTransferAllowed(status);
//			ccpo.clickOnControlTransferLevelDD();
//			csf.selectValueFromDropDown();
//			ccpo.clickOnFixedTransferTransferLevel();
//			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}

	public void c2cWithdrawValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectWithDrawAlloed(status);
			ccpo.clickOnControlWithdrawLevelDD();
			csf.selectValueFromDropDown();
			ccpo.clickOnFixedWithdrawLevelDD();
			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}
	
	public void modifyc2cWithdrawValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectWithDrawAlloed(status);
//			ccpo.clickOnControlWithdrawLevelDD();
//			csf.selectValueFromDropDown();
//			ccpo.clickOnFixedWithdrawLevelDD();
//			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}

	public void c2cReturnValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectReturnAllowed(status);
			ccpo.clickOnControlReturnLevelDD();
			csf.selectValueFromDropDown();
			ccpo.clickOnFixedReturnLevelDD();
			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}
	
	public void modifyc2cReturnValue(String value,String status) {

		switch (value) {
		case "SAME":
			ccpo.selectReturnAllowed(status);
//			ccpo.clickOnControlReturnLevelDD();
//			csf.selectValueFromDropDown();
//			ccpo.clickOnFixedReturnLevelDD();
//			csf.selectValueFromDropDown();
			break;

		default:
			break;
		}
	}
	
	
	public void checkIfParentAssociationAllowedAndRestrictedMobileNumberAllowed() {
		
		if(driver.findElement(By.id("mat-radio-3-input")).isEnabled() || driver.findElement(By.id("mat-radio-6-input")).isEnabled()) {
			Log.info("Sender Category is greater than Receiver Category ");
		}else {
			Log.info("Sender Category and Receiver Category are same");
		}
	}
	
	public void navigateToC2CTransferRulePage() {
		
		ccpo.clickOneTopUpTab();

		cspo.clickOnTransferRuleLink();
		ccpo.clickOnC2CTransferRuleLink();
	}
	
	public String  selectReceiverCategory(int index) {
		
		String value = null;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'ng-option')]")));

		List<WebElement> dropDownListValue = driver.findElements(By.xpath("//span[contains(@class,'ng-option')]"));

		// dropDownListValue =

		if (dropDownListValue.size() == 1) {
			Log.info("Only default value is there to select");
			value = dropDownListValue.get(0).getText();
			dropDownListValue.get(0).click();
		} else{
			value = dropDownListValue.get(index).getText();
			Log.info("Selected value from DD :" + value);
			dropDownListValue.get(index).click();

		}

		return value;
	}
	
	// Create Transfer Rule with same sender and receiver category
	public void createC2CTransferRule() {

		navigateToC2CTransferRulePage();
		
		ccpo.clickOnFromDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnToDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnProceedButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ccpo.clickOnAddAssociateTransferRule();

		ccpo.checkTransferRuleCraetionPageLoadedSuccessfully();
		

		ccpo.clickOnSenderDetailsCategoryDD();
		senderCategory = csf.selectValueFromDropDown();

		ccpo.clickOnReceiverDetailsCategoryDD();
		receiverCategory = csf.selectValueFromDropDown();

		ccpo.clickOnTransferTypeDD();
		csf.selectValueFromDropDown();

		if (senderCategory.equals(receiverCategory)) {
			ccpo.selectRestrictedRechargeAccess(yes);
			c2cTransferValue("SAME",yes);
			c2cWithdrawValue("SAME",yes);
			c2cReturnValue("SAME",yes);
		}
		
		checkIfParentAssociationAllowedAndRestrictedMobileNumberAllowed();
		
		ccpo.selecteTopUpForProductAssociation();
		ccpo.selectPosteTopUpForProductAssociation();
		
		ccpo.clickOnProceedButton();
		ccpo.checkReviewAndConfirmPageIsLoadedSuccessfully();
		ccpo.clickOnReviewAndConfirmButton();
		
		ccpo.checkSuccessWindowLoadedSuccessfully();
		ccpo.clickOnSuccessWindowDoneButton();

	}
	
	// Receiver category is lower than sender category
	public void createC2CTransferRuleSenderCategoryLowerThanReceiverCategory() {

		navigateToC2CTransferRulePage();
		
		ccpo.clickOnFromDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnToDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnProceedButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ccpo.clickOnAddAssociateTransferRule();

		ccpo.checkTransferRuleCraetionPageLoadedSuccessfully();
		

		ccpo.clickOnSenderDetailsCategoryDD();
		senderCategory = csf.selectValueFromDropDown();

		ccpo.clickOnReceiverDetailsCategoryDD();
		receiverCategory = selectReceiverCategory(2);

		ccpo.clickOnTransferTypeDD();
		csf.selectValueFromDropDown();

		if (senderCategory.equals(receiverCategory)) {
			ccpo.selectRestrictedRechargeAccess(yes);
			c2cTransferValue("SAME",yes);
			c2cWithdrawValue("SAME",yes);
			c2cReturnValue("SAME",yes);
		}else {
			ccpo.selectRestrictedRechargeAccess(yes);
			c2cTransferValue("SAME",yes);
			c2cWithdrawValue("SAME",yes);
			c2cReturnValue("SAME",yes);
			
			List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
			
			List<WebElement> checkBoxSelectionList = driver.findElements(By.xpath("(//label[contains(@class,'checkbox')]//following-sibling::span[contains(@class,'mat-checkbox')])"));
			
			for(int i =0;i<checkBoxList.size();i++ ) {
				if(checkBoxList.get(i).isEnabled()) {
					checkBoxSelectionList.get(i).click();
				}
			}
		}
		
		checkIfParentAssociationAllowedAndRestrictedMobileNumberAllowed();
		
		driver.findElement(By.xpath("(//div[@class='mat-radio-label-content'])[1]")).click();
		
//		ccpo.selecteTopUpForProductAssociation();
//		ccpo.selectPosteTopUpForProductAssociation();
		
		ccpo.clickOnProceedButton();
		ccpo.checkReviewAndConfirmPageIsLoadedSuccessfully();
		ccpo.clickOnReviewAndConfirmButton();
		
		ccpo.checkSuccessWindowLoadedSuccessfully();
		ccpo.clickOnSuccessWindowDoneButton();

	}
	
	public void modifyC2CTransferRule() {
		
		ccpo.clickOnFromDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnToDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnProceedButton();
		
		ccpo.clickOnEditButton();
		
		ccpo.checkTransferRuleCraetionPageLoadedSuccessfully();

//		ccpo.clickOnTransferTypeDD();
//		csf.selectValueFromDropDown();

		if (senderCategory.equals(receiverCategory)) {
			ccpo.selectRestrictedRechargeAccess(no);
			modifyc2cTransferValue("SAME",no);
			modifyc2cWithdrawValue("SAME",no);
			modifyc2cReturnValue("SAME",no);
		}
		
//		ccpo.selecteTopUpForProductAssociation();
//		ccpo.selectPosteTopUpForProductAssociation();
		
		ccpo.clickOnProceedButton();
		ccpo.checkReviewAndConfirmPageIsLoadedSuccessfully();
		ccpo.clickOnReviewAndConfirmButton();
		
		ccpo.checkSuccessWindowLoadedSuccessfully();
		ccpo.clickOnSuccessWindowDoneButton();
		
		
	}
	
	public void deleteC2CTransferRule() {
		
		ccpo.clickOnFromDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnToDomainDDButton();
		csf.selectValueFromDropDown();
		
		ccpo.clickOnProceedButton();
		ccpo.clickOnDeleteIcon();
		
		ccpo.checkVisibilityOfDeleteConfirmation();
		ccpo.deletConfirmation(yes);
		
		ccpo.checkSuccessWindowLoadedSuccessfully();
		ccpo.clickOnSuccessWindowDoneButton();
	}
	
	public void createModifyDelete_C2CTransferRule(String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		createC2CTransferRule();
		
		if(!ccpo.checkAssociateC2CTransferRule()) {
			navigateToC2CTransferRulePage();
		}
		
		modifyC2CTransferRule();
		
		if(!ccpo.checkAssociateC2CTransferRule()) {
			navigateToC2CTransferRulePage();
		}
		
		deleteC2CTransferRule();
		
	}
	
	public void createC2CTransferRuleWithReceiverCategoryLowerTHenSenderCategory( String loginId, String password) {
		
		login.LoginAsUser(driver, loginId, password);
		createC2CTransferRuleSenderCategoryLowerThanReceiverCategory();
		
//		if(!ccpo.checkAssociateC2CTransferRule()) {
//			navigateToC2CTransferRulePage();
//		}
//		
//		deleteC2CTransferRule();
	}
}
