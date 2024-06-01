package angular.feature.TransferRules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

import angular.classes.LoginRevamp;
import angular.pageobjects.TranferRule.O2CAddModifyDeleteTransferRule;

public class O2C_AddModifyDelete_TransferRule_Feature extends BaseTest {
		
	public WebDriver driver;
	LoginRevamp login;
	O2CAddModifyDeleteTransferRule transRule;
	WebDriverWait wait;

	public O2C_AddModifyDelete_TransferRule_Feature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		transRule = new O2CAddModifyDeleteTransferRule(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void navigateToO2CTransferRuleLink() {
		
	}
	
	//Select domain from the select domain DD
	public int selectDomainFromCategoryDomain(int index) {
		Log.info("Trying to select domain from Select category DD");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.clickOnCategoryDomainDD();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")));
		List<WebElement> domainDD = driver.findElements(By.xpath("//div[@role='option']"));
		int size = domainDD.size();
		String s = domainDD.get(index).getText();
		domainDD.get(index).click();
		Log.info("Selected domain as : "+s);
		transRule.clickOnCategoryDomainProceedButton();
		return size;	
	}
	
	public String proceedWithAddTransferRule() {
		int categoryDomainDDValueSize = 0, categoryIndex=0;
		String s = null;
		Log.info("Proceeding to View Associate Transfer Rule Details");
		categoryDomainDDValueSize = selectDomainFromCategoryDomain(categoryIndex);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		transRule.clickOnAddAssociateTransferRuleButton();
		transRule.checkAssociateTransferRulePageLoadedSuccessfully();
		transRule.clickOnToCategoryDD();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]")));
		List<WebElement> domainDD = driver.findElements(By.xpath("//div[@role='option']"));
		if(domainDD.size() == 0) {
			Log.info("No value found in to category dd, please select another domain category");
		}else {
			s = domainDD.get(categoryIndex).getText();
			domainDD.get(categoryIndex).click();
			Log.info("Selected to category as : "+s);
		}
		return s;
	}
	
	public void setTransferValuesAsYes() {
		transRule.selectTransferSalesAllowedYes();
		transRule.selectFOCAllowedYes();
		transRule.selectBulkCommissionSelectYes();
	}
	
	public void setTransferValuesAsNo() {
		transRule.selectTransferSalesAllowedNo();
		transRule.selectFOCAllowedNo();
		transRule.selectBulkCommissionSelectNo();
	}
	
	public void associateAllProducts() {
		Log.info("Associating all products with transfer rule");
		transRule.selecteTopUpProductAssociation();
		transRule.selectPosteTopUpProductAssociation();
	}
	
	
	// Add O2C Transfer Rule 
	public String createO2CTransferRule(String firstApproval,String secondApproval) {
		String toCategory =null;
		Log.info("Trying to perform add O2C Transfer Rule");
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		toCategory = proceedWithAddTransferRule();
		setTransferValuesAsYes();
		transRule.selectWithdrawalAllowedYes();
		transRule.selectReturnAllowedYes();
		transRule.inputFirstApporvalLimit(firstApproval);
		transRule.inputSecondApprovalLimit(secondApproval);
		associateAllProducts();
		transRule.clickOnCategoryDomainProceedButton();
		transRule.checkMessageWindowLoadedSuccessfully();
		transRule.clickOnDoneButton();
		
		return toCategory;
	}
	
	public void createO2CTransferRuleWithSeconLimitLessThanFirst(String firstApproval,String secondApproval) {
		String toCategory =null;
		Log.info("Trying to perform add O2C Transfer Rule");
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		toCategory = proceedWithAddTransferRule();
		setTransferValuesAsYes();
		transRule.selectWithdrawalAllowedYes();
		transRule.selectReturnAllowedYes();
		transRule.inputFirstApporvalLimit(firstApproval);
		transRule.inputSecondApprovalLimit(secondApproval);
		associateAllProducts();
		transRule.clickOnCategoryDomainProceedButton();
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'errorMessage1')]//div"))).getText();
		Log.info("Error message recieved for Second Approval less than First Approval"+message);
	}
	
	// Delete Transfer Rule
	public void deleteO2CTransferRule(String toCategory) {
		Log.info("Trying to delete created O2C Transfer Rule");
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		selectDomainFromCategoryDomain(0);
		transRule.checkSearchResultLoadedSuccessfully();
		transRule.inputValueInSearchField(toCategory);
		transRule.clickOnDeleteIcon();
		transRule.clickOnAcceptDelete();
		transRule.checkMessageWindowLoadedSuccessfully();
		transRule.clickOnDoneButton();
	}
	
	// Modify Transfer Rule
	public void modifyO2CTransferRule(String toCategory) {
		
		Log.info("Trying to delete created O2C Transfer Rule");
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		selectDomainFromCategoryDomain(0);
		transRule.checkSearchResultLoadedSuccessfully();
		transRule.inputValueInSearchField(toCategory);
		transRule.clickOnModifyIcon();
		setTransferValuesAsNo();
		transRule.selectWithdrawalAllowedNo();
		transRule.selectReturnAllowedNo();
		transRule.clickOnCategoryDomainProceedButton();
		transRule.checkMessageWindowLoadedSuccessfully();
		transRule.clickOnDoneButton();
	}
	
	public void Perform_O2C_AddModifyDelete_TransferRule(String logindid,String password) {
		login.LoginAsUser(driver, logindid, password);
		String toCategory = createO2CTransferRule("100","200");
		modifyO2CTransferRule(toCategory);
		deleteO2CTransferRule(toCategory);
	}
	
	public void Perform_O2C_Add_TransferRule_SecondApprovalIsLessThanFirst(String logindid,String password) {
		
		login.LoginAsUser(driver, logindid, password);
		createO2CTransferRuleWithSeconLimitLessThanFirst("200","100");
		
	}
	
	public void Perform_O2C_Add_TransferRule_UserIsnavigatedBackTo_SelectCategoryDomainPage_UponClickinBackButton(String logindid,String password) {
		
		login.LoginAsUser(driver, logindid, password);

		Log.info("Trying to perform add O2C Transfer Rule");
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		selectDomainFromCategoryDomain(0);
		transRule.clickOnCategoryDomainProceedButton();
		transRule.clickOnAddAssociateTransferRuleButton();
		transRule.checkAssociateTransferRulePageLoadedSuccessfully();
		transRule.clickOnCategoryDomainReset();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
	}
	
	public void VerifyUserIsAbleToResetCategoryDomainSelection(String logindid,String password) {
		
		login.LoginAsUser(driver, logindid, password);
		
		transRule.checkVisibilityOfTransferRuleLink();
		transRule.clickOnTransferRuleLink();
		transRule.clickOnO2CTransferRuleLink();
		transRule.checkAssociateO2CTransRulePageLoadedSuccessfully();
		selectDomainFromCategoryDomain(0);
		transRule.clickOnCategoryDomainReset();
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='domainCode']//following::div[contains(@class,'ng-has-value')]")));
			Log.info("Category Reset was not successfull");
		}catch(Exception e) {
			Log.info("Category Reset was successfull");
		}
		
		
	}
}
