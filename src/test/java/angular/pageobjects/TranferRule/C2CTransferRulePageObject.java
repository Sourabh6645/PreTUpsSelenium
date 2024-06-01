package angular.pageobjects.TranferRule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;
import com.utils.Log;

public class C2CTransferRulePageObject extends BaseTest {

	// eTopUp Tab
	@FindBy(xpath = "//div[@id='mat-tab-label-1-0']//div")
	private WebElement eTopupTab;

	// C2C Transfer Rule link
	@FindBy(xpath = "//a[@href='/pretups-ui/trfRule-C2C']")
	private WebElement c2cTransferRuleLink;

	@FindBy(xpath = "(//label[@for='fromDomainCode']//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement fromDomainDDButton;

	@FindBy(xpath = "(//label[@for='fromDomainCode']//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement ToDomainDDButton;

	@FindBy(xpath = "//button[@name='Reset']//span")
	private WebElement resetButton;

	@FindBy(xpath = "//button[@name='Proceed']//span")
	private WebElement proceedButton;

	@FindBy(xpath = "//button[@id='addTransferRuleButton']")
	private WebElement addAssociationTransferRuleButton;

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchRuleField;

	@FindBy(xpath = "(//a[@class='viewRecord'])[1]")
	private WebElement viewRecordButton;

	@FindBy(xpath = "(//a[@class='editRecord'])[1]")
	private WebElement editRecoedButton;

	@FindBy(xpath = "(//a[@class='deleteRecord'])[1]")
	private WebElement deleteRecordButton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[1]")
	private WebElement selectSenderCategoryDDButton;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[1]")
	private WebElement parentAssociationAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[2]")
	private WebElement parentAssociationAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[3]")
	private WebElement restrictedMobileAccessYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[4]")
	private WebElement restrictedMobileAccessNo;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[2]")
	private WebElement selectReceiverCategoryDDButton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[3]")
	private WebElement selectTransferTypeDDButton;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[5]")
	private WebElement restrictedRechargeAccessYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[6]")
	private WebElement restrictedRechargeAccessNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[7]")
	private WebElement directTransferAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[8]")
	private WebElement directTransferAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[9]")
	private WebElement channelBypassInTransferAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[10]")
	private WebElement channelBypassInTransferAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[11]")
	private WebElement uncontrolTransferAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[12]")
	private WebElement uncontrolTransferAllowedNo;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[4]")
	private WebElement uncontrolTransferAllowedDDbuton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[5]")
	private WebElement controlTransferLevelDDbuton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[6]")
	private WebElement fixedTransferLevelDDbuton;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[13]")
	private WebElement withdrawalAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[14]")
	private WebElement withdrawalAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[15]")
	private WebElement channelBypassInWithdrawalAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[16]")
	private WebElement channelBypassInWithdrawalAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[17]")
	private WebElement uncontrolWithdrawalAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[18]")
	private WebElement uncontrolWithdrawalAllowedNo;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[7]")
	private WebElement uncontrolledWithdrawalLevelDDButton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[8]")
	private WebElement controlWithdrawalAllowedDDbuton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[9]")
	private WebElement fixedWithdrawalLavelDDbuton;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[19]")
	private WebElement returnAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[20]")
	private WebElement returnAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[21]")
	private WebElement channelBypassInReturnAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[22]")
	private WebElement channelBypassInReturnAllowedNo;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[23]")
	private WebElement uncontrolReturnAllowedYes;

	@FindBy(xpath = "(//label[@class='mat-radio-label'])[24]")
	private WebElement uncontrolReturnAllowedNo;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[10]")
	private WebElement uncontrolReturnLevelDDButton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[11]")
	private WebElement controlReturnLevelDDButton;

	@FindBy(xpath = "(//div[contains(@class,'subHeadingList')]//following::span[@class='ng-arrow-wrapper'])[12]")
	private WebElement fixedReturnLevelDDButton;

	@FindBy(xpath = "(//div[@formarrayname='productArray']//span[@class='mat-checkbox-label'])[1]")
	private WebElement eTopupProduct;

	@FindBy(xpath = "(//div[@formarrayname='productArray']//span[@class='mat-checkbox-label'])[2]")
	private WebElement postETopupProduct;

	@FindBy(xpath = "//h4[@id='modal-basic-title']")
	private WebElement reviewAndConfirmWindow;

	@FindBy(xpath = "//button[@id='closeId']")
	private WebElement reviewAndConfirmWindowCloseButton;

	@FindBy(xpath = "(//button[@name='Reset']//span)[2]")
	private WebElement reviewAndConfirmBackButton;

	@FindBy(xpath = "(//button[@name='Proceed']//span)[2]")
	private WebElement reviewAndConfirmButton;

	@FindBy(xpath = "//div[@class='success']")
	private WebElement successTransferRuleWindow;

	@FindBy(xpath = "//button[@id='anotherRecharge']//span")
	private WebElement successWindowDoneButton;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement deleteActionConfirmation;
	
	@FindBy(id = "rejectConfirmNo")
	private WebElement rejectDeleteConfirmation;
	
	@FindBy(id = "rejectConfirmYes")
	private WebElement acceptDeleteConfirmation;
	
	

	/* ----- WebDriver Declaration ----- */

	WebDriver driver = null;
	WebDriverWait wait = null;

	public C2CTransferRulePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	/* ----- Basic Function ------ */

	public boolean checkVisibilityOfETopUp() {
		Log.info("Checking visibility of eTopUp Tab");

		try {
			wait.until(ExpectedConditions.visibilityOf(eTopupTab));
			Log.info("eTopUp tab is visible");
			return true;
		} catch (Exception e) {
			Log.info("eTopUp tab is not visible");
			return false;
		}
	}

	public void clickOneTopUpTab() {
		Log.info("Trying to click on eTopUp tab");
		if (checkVisibilityOfETopUp()) {
			eTopupTab.click();
			Log.info("Clicked on eTopUp tab");
		} else {
			Log.info("Unable to click on eTopUp tab as its not visible");
		}
	}

	public boolean checkVisibilityOfC2CTransferRuleLink() {
		Log.info("Checking visibilty of C2C transfer rule link");

		try {
			wait.until(ExpectedConditions.visibilityOf(c2cTransferRuleLink));
			Log.info("C2C Transfer rule link is visible");
			return true;
		} catch (Exception e) {
			Log.info("C2C transfer rule link is not visible");
			return false;
		}
	}

	public void clickOnC2CTransferRuleLink() {
		Log.info("Trying to click on C2C Transfer Rule link");

		if (checkVisibilityOfC2CTransferRuleLink()) {
			c2cTransferRuleLink.click();
			Log.info("Clicked on C2C transfer rule link");
		} else {
			Log.info("Unable to click on C2C transfer rule link");
		}
	}

	public boolean checkAssociateC2CTransferRule() {
		Log.info("Checking if Associate channel to channel transfer rule page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(fromDomainDDButton));
			wait.until(ExpectedConditions.visibilityOf(ToDomainDDButton));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(proceedButton));
			Log.info("Associate C2C transfer rule page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Associate C2C transfer rule page not loaded successfully");
			return false;
		}
	}

	public void clickOnFromDomainDDButton() {
		Log.info("Trying to click on from domain DD button");
		wait.until(ExpectedConditions.visibilityOf(fromDomainDDButton)).click();
		Log.info("Clicked on from domain DD button");
	}

	public void clickOnToDomainDDButton() {
		Log.info("Trying to click on to domain DD button");
		wait.until(ExpectedConditions.visibilityOf(ToDomainDDButton)).click();
		Log.info("Clicked on domain DD button");
	}

	public void clickOnResetButton() {
		Log.info("Trying to click on reset button");
		wait.until(ExpectedConditions.visibilityOf(resetButton)).click();
		Log.info("Clicked on reset button");
	}

	public void clickOnProceedButton() {
		Log.info("Trying to click on proceed button");
		wait.until(ExpectedConditions.visibilityOf(proceedButton)).click();
		Log.info("Clicked on proceed button");
	}

	public boolean checkTransferRulesLoadedSuccessfully() {
		Log.info("Checking visibilty of transfer rules loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(addAssociationTransferRuleButton));
			wait.until(ExpectedConditions.visibilityOf(searchRuleField));
			Log.info("Transfer rule page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Transfer rule not loaded successfully");
			return false;
		}
	}

	public void clickOnAddAssociateTransferRule() {
		Log.info("Trying to click on add associate transfer rule button");
		wait.until(ExpectedConditions.visibilityOf(addAssociationTransferRuleButton)).click();
		Log.info("Clicked on add and associate transfer rule button");
	}

	public boolean checkTransferRuleCraetionPageLoadedSuccessfully() {

		Log.info("Checking if Transfer Rule creation page loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(eTopupProduct));
			wait.until(ExpectedConditions.visibilityOf(postETopupProduct));
			wait.until(ExpectedConditions.visibilityOf(resetButton));
			wait.until(ExpectedConditions.visibilityOf(proceedButton));
			Log.info("Transfer rule creation page loaded successfully");
			return true;
		} catch (Exception e) {
			Log.info("Transfer rule creation page is not loaded");
			return false;
		}
	}

	public void clickOnSenderDetailsCategoryDD() {
		Log.info("Trying to click on sender details category DD");
		wait.until(ExpectedConditions.visibilityOf(selectSenderCategoryDDButton)).click();
		Log.info("Clicked on sender details category DD");
	}

	public void selectParentAssociationAlloed(String value) {
		if (value.equals("YES")) {
			parentAssociationAllowedYes.click();
		} else {
			parentAssociationAllowedNo.click();
		}

		Log.info("Selected parent association value is : " + value);
	}

	public void selectRestrictedMobileNumberAccess(String value) {

		if (value.equals("YES")) {
			restrictedMobileAccessYes.click();
		} else {
			restrictedMobileAccessNo.click();
		}

		Log.info("Selected restric mobile number access is : " + value);
	}

	public void clickOnReceiverDetailsCategoryDD() {
		Log.info("Trying to click on receiver details category DD");
		wait.until(ExpectedConditions.visibilityOf(selectReceiverCategoryDDButton)).click();
		Log.info("Clicked on receiver category DD");
	}

	public void clickOnTransferTypeDD() {
		Log.info("Trying to click on Transfer Type DD");
		wait.until(ExpectedConditions.visibilityOf(selectTransferTypeDDButton)).click();
		Log.info("Clicked on Transfer Type DD");
	}

	public void selectRestrictedRechargeAccess(String value) {

		if (value.equals("YES")) {
			restrictedRechargeAccessYes.click();
		} else {
			restrictedRechargeAccessNo.click();
		}

		Log.info("Selected restricted recharge access value as : " + value);
	}

	public void selectDirectTransferAllowed(String value) {

		if (value.equals("YES")) {
			directTransferAllowedYes.click();
		} else {
			directTransferAllowedNo.click();
		}

		Log.info("Selected direct transfer allowed value as : " + value);
	}

	public void selectChannelBypassInTransferAllowed(String value) {

		if (value.equals("YES")) {
			channelBypassInTransferAllowedYes.click();
		} else {
			channelBypassInTransferAllowedNo.click();
		}

		Log.info("Selected channel by pass in transfer allowed value as : " + value);
	}

	public void selectUncontrolTransferAllowed(String value) {

		if (value.equals("YES")) {
			uncontrolTransferAllowedYes.click();
		} else {
			uncontrolTransferAllowedNo.click();
		}

		Log.info("Selected restricted recharge access value as : " + value);
	}

	public void clickOnUncontrolTransferLevel() {
		Log.info("Trying to click on Uncontrol Transfer Level DD");
		wait.until(ExpectedConditions.visibilityOf(uncontrolTransferAllowedDDbuton)).click();
		Log.info("Clicked on Uncontrol Transfer Level DD");
	}

	public void clickOnControlTransferLevelDD() {
		Log.info("Trying to click on Control Transfer Level DD");
		wait.until(ExpectedConditions.visibilityOf(controlTransferLevelDDbuton)).click();
		Log.info("Clicked on Control Transfer Level DD");
	}

	public void clickOnFixedTransferTransferLevel() {
		Log.info("Trying to click on Fixed Transfer Level DD");
		wait.until(ExpectedConditions.visibilityOf(fixedTransferLevelDDbuton)).click();
		Log.info("Clicked on Fixed Transfer Level DD");
	}

	public void selectWithDrawAlloed(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(withdrawalAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(withdrawalAllowedNo)).click();
		}

		Log.info("Selected Withdrawal allowed as : " + value);
	}

	public void selectChannelBypassInWithdrawalAllowed(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(channelBypassInReturnAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(channelBypassInReturnAllowedNo)).click();
		}

		Log.info("Selected Channel Bypass In Withdrawal Allowed as : " + value);
	}

	public void selectUncontrolWithdrawAllowed(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(uncontrolWithdrawalAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(uncontrolWithdrawalAllowedNo)).click();
		}

		Log.info("Selected Uncontrolled Withdrawal Allowed as : " + value);
	}

	public void clickOnUncontrolWithdrawLevel() {
		Log.info("Trying to click on Uncontrol Withdraw Level DD");
		wait.until(ExpectedConditions.visibilityOf(uncontrolledWithdrawalLevelDDButton)).click();
		Log.info("Clicked on Uncontrol Withdraw Level DD");
	}

	public void clickOnControlWithdrawLevelDD() {
		Log.info("Trying to click on Control Withdraw Level DD");
		wait.until(ExpectedConditions.visibilityOf(controlWithdrawalAllowedDDbuton)).click();
		Log.info("Clicked on Control Withdraw Level DD");
	}

	public void clickOnFixedWithdrawLevelDD() {
		Log.info("Trying to click on Fixed Withdraw Level DD");
		wait.until(ExpectedConditions.visibilityOf(fixedWithdrawalLavelDDbuton)).click();
		Log.info("Clicked on Fixed Withdraw Level DD");
	}

	public void selectReturnAllowed(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(returnAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(returnAllowedNo)).click();
		}

		Log.info("Selected Return Allowed as : " + value);
	}
	
	public void selectChannelBypassInReturnAllowed(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(channelBypassInReturnAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(channelBypassInReturnAllowedNo)).click();
		}

		Log.info("Selected Channel Bypass In Return Allowed as : " + value);
	}
	
	public void selectUncontrolReturnLevel(String value) {

		if (value.equals("YES")) {
			wait.until(ExpectedConditions.visibilityOf(uncontrolReturnAllowedYes)).click();
		} else {
			wait.until(ExpectedConditions.visibilityOf(uncontrolReturnAllowedNo)).click();
		}

		Log.info("Selected Uncontrol Return Allowed as : " + value);
	}
	
	public void clickOnUncontrolReturnLevelDD() {
		Log.info("Trying to click on Uncontrol Return Level DD");
		wait.until(ExpectedConditions.visibilityOf(uncontrolReturnLevelDDButton)).click();
		Log.info("Clicked on Uncontrol Return Level DD");
	}
	
	public void clickOnControlReturnLevelDD() {
		Log.info("Trying to click on Control Return Level DD");
		wait.until(ExpectedConditions.visibilityOf(controlReturnLevelDDButton)).click();
		Log.info("Clicked on Control Return Level DD");
	}
	
	public void clickOnFixedReturnLevelDD() {
		Log.info("Trying to click on Fixed Return Level DD");
		wait.until(ExpectedConditions.visibilityOf(fixedReturnLevelDDButton)).click();
		Log.info("Clicked on Fixed Return Level DD");
	}
	
	public void selecteTopUpForProductAssociation() {
		wait.until(ExpectedConditions.visibilityOf(eTopupProduct)).click();
		Log.info("Selected product as eTopUp");
	}
	
	public void selectPosteTopUpForProductAssociation() {
		wait.until(ExpectedConditions.visibilityOf(postETopupProduct)).click();
		Log.info("Selected product as Post eTopUp");
	}
	
	public boolean checkReviewAndConfirmPageIsLoadedSuccessfully() {
		Log.info("Checking if review and confirm page is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmWindow));
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmWindowCloseButton));
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmButton));
			wait.until(ExpectedConditions.visibilityOf(reviewAndConfirmBackButton));
			Log.info("Review and confirm page loaded successfully");
			return true;
		}catch(Exception e) {
			Log.info("Review and confirm page is not loaded successfully");
			return false;
		}
	}
	
	public void clickOnReviewAndConfirmCloseButton() {
		if(checkReviewAndConfirmPageIsLoadedSuccessfully()) {
			reviewAndConfirmWindowCloseButton.click();
			Log.info("Clicked on review and confirm close button");
		}
		Log.info("Unable to click on review and confirm close button");
	}
	
	public void clickOnReviewAndConfirmBackButton() {
		if(checkReviewAndConfirmPageIsLoadedSuccessfully()) {
			reviewAndConfirmBackButton.click();
			Log.info("Clicked on review and confirm close button");
		}
		Log.info("Unable to click on review and confirm back button");
	}
	
	public void clickOnReviewAndConfirmButton() {
		if(checkReviewAndConfirmPageIsLoadedSuccessfully()) {
			reviewAndConfirmButton.click();
			Log.info("Clicked on review and confirm button");
		}
	}
	
	public boolean checkSuccessWindowLoadedSuccessfully() {
		Log.info("Checking if success window is loaded successfully");
		try {
			wait.until(ExpectedConditions.visibilityOf(successTransferRuleWindow));
			Log.info("Success window is visible");
			return true;
		}catch(Exception e) {
			Log.info("Success windoe is not visible");
			return false;
		}
	}
	
	public void clickOnSuccessWindowDoneButton() {
		if(checkSuccessWindowLoadedSuccessfully()) {
			successWindowDoneButton.click();
			Log.info("Clicked on success window done button");
		}
	}
	
	public void clickOnEditButton() {
		wait.until(ExpectedConditions.visibilityOf(editRecoedButton)).click();
		Log.info("Clicked on edit record button");
	}
	
	public void clickOnDeleteIcon() {
		wait.until(ExpectedConditions.visibilityOf(deleteRecordButton)).click();
		Log.info("Clicked on delete record button");
	}
	
	public boolean checkVisibilityOfDeleteConfirmation() {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(deleteActionConfirmation));
			wait.until(ExpectedConditions.visibilityOf(rejectDeleteConfirmation));
			wait.until(ExpectedConditions.visibilityOf(acceptDeleteConfirmation));
			Log.info("Delete confirmation window is visbile");
			return true;
		}catch(Exception e) {
			Log.info("Delete confirmation window is not loaded");
			return false;
		}
	}
	
	public void deletConfirmation(String value) {
		
		if(value.equals("YES")) {
			acceptDeleteConfirmation.click();
			Log.info("Confirmed Delete");
		}else {
			rejectDeleteConfirmation.click();
			Log.info("Rejected Deleted");
		}
	}
}
