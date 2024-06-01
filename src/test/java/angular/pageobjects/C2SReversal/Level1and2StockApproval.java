package angular.pageobjects.C2SReversal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.classes.BaseTest;

public class Level1and2StockApproval extends BaseTest{
	
	// eTopUp Tab
			@FindBy(xpath = "//div[@id='mat-tab-label-1-0']//div")
			private WebElement eTopupTab;
			
	// Level 1 & 2 Stock Approval
			@FindBy (xpath="//span[contains(text(),'Approval Level 1')]")
			private WebElement ApprovalLevel1Option;
			//discuss
			@FindBy (xpath="//a[@class='list-group-item box-opener ng-star-inserted']//span[contains(text(),'Network Stock')][1]")
			private WebElement NetworkStockL1;
			
			@FindBy (xpath="//span[contains(text(),'Transaction')]")
			private WebElement TransactionButtonL1;
			
			@FindBy (xpath="//input[@name='search']")
			private WebElement SearchBarL1;
			
			@FindBy (xpath="//a[@id='parentTable_next']")
			private WebElement NextPgaeBottonDataTableL1;
			
			@FindBy (xpath="//label[@title='Edit user']//a[contains(text(),'APPROVE')][1]")
			private WebElement ApproveStockInDataTableL1;
			
			@FindBy (xpath="//label[@title='reject user']//a[contains(text(),'REJECT')][1]")
			private WebElement RejectStockInDataTableL1;
			
			@FindBy (xpath="//span[contains(text(),'YES')]")
			private WebElement YesToRejectStockL1;
			
			//Approved quantity xpath need discussion
			
			@FindBy (xpath="//textarea[@class='textarea ng-pristine ng-valid ng-touched']")
			private WebElement FirstApproverRemarksL1;
			
			@FindBy (xpath="//span[contains(text(),'RESET')]")
			private WebElement ResetButtonDetailScreenL1;
			
			@FindBy (xpath="//span[contains(text(),'PROCEED')]")
			private WebElement ProceedButtonDetailScreenL1;
			
			@FindBy (xpath="//span[contains(text(),'RESET')]")
			private WebElement ResetButtonConfirmScreenL1;
			
			@FindBy (xpath="//span[contains(text(),'APPROV')]")
			private WebElement ApprovetButtonConfirmScreenL1;
			
			@FindBy (xpath="//span[contains(text(),'REJECT')]")
			private WebElement RejectButtonConfirmScreenL1;
			
			@FindBy (xpath="//span[contains(text(),'DONE')]")
			private WebElement DoneButtonInPopupL1;
			
			@FindBy (xpath="//span[contains(text(),'Approval Level 2')]")
			private WebElement ApprovalLevel2Option;
			//discuss
			@FindBy (xpath="//a[@class='list-group-item box-opener ng-star-inserted']//span[contains(text(),'Network Stock')][2]")
			private WebElement NetworkStockL2;
			
			
			
			

}
