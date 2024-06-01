package angular.feature;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.classes.BaseTest;

import angular.classes.LoginRevamp;
import angular.pageobjects.User.OperatorUserCreationApproval;
import angular.pageobjects.c2capproval.C2CApproval;
import angular.pageobjects.c2ctransfer.C2CTransfers;

public class OperatorUserCreationAndApprovalFeature extends BaseTest {

	public WebDriver driver;
	LoginRevamp login;
	C2CTransfers transfers;
	C2CApproval approval;
	OperatorUserCreationApproval oprUserCr;
	WebDriverWait wait;
	
	String fromSerialId = null;
	String toSerialId = null;
	
	
	public OperatorUserCreationAndApprovalFeature(WebDriver driver) {
		this.driver = driver;
		login = new LoginRevamp();
		transfers = new C2CTransfers(driver);
		approval = new C2CApproval(driver);
		oprUserCr = new OperatorUserCreationApproval(driver);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void performUserCreationAndApproval(String loginId,String password) {
		
		login.LoginAsUser(driver, loginId, password);
		
		oprUserCr.visibilityOfOperatorUserLink();
		oprUserCr.clickOnOperatorUserLink();
		oprUserCr.visibilityOfSingleUserCreationLink();
		oprUserCr.clickOnSingleUserCreationButton();
		oprUserCr.visibilityOfAddUserCategory();
		oprUserCr.clickOnCategorySelection();
		
		WebElement categoryDD = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']")));
		
		List<WebElement> catgoryDDValue = driver.findElements(By.xpath("//div[@role='option']"));
		
		if(!catgoryDDValue.isEmpty()) {
			
			catgoryDDValue.get(0).click();
		}
		
		oprUserCr.clickOnSelectCategoryProceed();
		oprUserCr.visibilityOfPersonalDetailsPage();
		oprUserCr.clickOnTitleDropDownButton();
		
	}
}
