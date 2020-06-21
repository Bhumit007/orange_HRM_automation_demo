package OrangeHRMPages;

import OrangeHRMTest.BaseTest;
import OrangeHRMTest.TestListener;
import Utility.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EmployeeLeaveProcessPage extends BaseTest {

    String fullName;

    public EmployeeLeaveProcessPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "txtUsername")
    protected WebElement txtAdminUserName;

    @FindBy(id = "txtPassword")
    protected WebElement txtAdminPassword;

    @FindBy(id = "btnLogin")
    protected WebElement btnLogin;

    @FindBy(id = "welcome")
    protected WebElement txtWelcomeAdmin;

    @FindBy(id = "menu_pim_viewPimModule")
    protected WebElement clickOnPIM;

    @FindBy(id = "menu_pim_addEmployee")
    protected WebElement clickOnAddEmployee;

    @FindBy(id = "firstName")
    protected WebElement txtFirstName;

    @FindBy(id = "lastName")
    protected WebElement txtLastName;

    @FindBy(id = "photofile")
    private WebElement btnChooseFile;

    @FindBy(id = "chkLogin")
    protected WebElement checkBoxLogin;

    @FindBy(id = "user_name")
    protected WebElement txtUserName;

    @FindBy(id = "user_password")
    protected WebElement txtPassword;

    @FindBy(id = "re_password")
    protected WebElement txtConfirmPassword;

    @FindBy(id = "btnSave")
    protected WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'message success')]")
    protected WebElement successMessage;

    @FindBy(id = "personal_txtLicenNo")
    protected WebElement txtDriverLicenceNumber;

    @FindBy(id = "personal_txtLicExpDate")
    protected WebElement txtLicenceExpiryDate;

    @FindBy(id = "personal_txtNICNo")
    protected WebElement txtSSNNumber;

    @FindBy(id = "personal_optGender_2")
    protected WebElement radioBtnGender;

    @FindBy(id = "personal_cmbMarital")
    protected WebElement selectMaritalStatus;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    protected WebElement selectNationality;

    @FindBy(id = "personal_DOB")
    protected WebElement txtDateOfBirth;

    @FindBy(id = "menu_leave_viewLeaveModule")
    protected WebElement clickOnLeave;

    @FindBy(id = "menu_leave_Entitlements")
    protected WebElement clickOnEntitlements;

    @FindBy(id = "menu_leave_addLeaveEntitlement")
    protected WebElement clickAddLeaveEntitlement;

    @FindBy(name = "entitlements[employee][empName]")
    protected WebElement txtEmployeeName;

    @FindBy(xpath = "//li[contains(@class,'ac_even')]")
    protected WebElement selectEmployeeName;

    @FindBy(id = "entitlements_entitlement")
    protected WebElement txtEntitlement;

    @FindBy(id = "menu_leave_assignLeave")
    protected WebElement clickOnAssignLeave;

    @FindBy(name = "assignleave[txtEmployee][empName]")
    public WebElement txtAssignEmployeeName;

    //@FindBy(id = "assignleave_txtLeaveType")
    @FindBy(name = "assignleave[txtLeaveType]")
    public WebElement selectLeaveType;

    @FindBy(id = "assignleave_leaveBalance")
    public WebElement txtLeaveBalance;

    @FindBy(id = "assignleave_txtFromDate")
    public WebElement txtAssignFromDate;

    @FindBy(id = "assignleave_txtToDate")
    public WebElement txtAssignToDate;

    @FindBy(xpath = "//input[@id='assignBtn']")
    protected WebElement btnAssign;

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement tabAdmin;

    @FindBy(name = "searchSystemUser[employeeName][empName]")
    public WebElement txtSearchSystemUserEmployeeName;

    @FindBy(id = "searchBtn")
    public WebElement btnSearch;

    @FindBy(name = "chkSelectRow[]")
    public WebElement CheckBoxRow;

    @FindBy(id = "btnDelete")
    public WebElement btnDelete;

    @FindBy(id = "dialogDeleteBtn")
    public WebElement dialogButton;

    /**
     * Enter Login Detail.
     *
     * @return
     */
    public EmployeeLeaveProcessPage adminLogin() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtAdminUserName, driver);
        Utilities.getUtilities().sendKey(txtAdminUserName, prop.getProperty("adminUserName"));
        Utilities.getUtilities().waitForVisibilityOfElement(txtAdminPassword, driver);
        Utilities.getUtilities().sendKey(txtAdminPassword, prop.getProperty("adminPassword"));
        TestListener.saveScreenshotPNG(driver);
        return this;
    }

    /**
     * Click on sign in button
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnLoginButton() {
        Utilities.getUtilities().clickOnElement(btnLogin, driver);
        return this;
    }

    /**
     * verify  Welcome Page
     *
     * @return
     */
    public EmployeeLeaveProcessPage verifyHomePage() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtWelcomeAdmin, driver);
        return this;
    }

    /**
     * click on PIM
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnPIM() {
        Utilities.getUtilities().clickOnElement(clickOnPIM, driver);
        return this;
    }

    /**
     * click on Add Employee Tab
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnAddEmployee() {
        Utilities.getUtilities().clickOnElement(clickOnAddEmployee, driver);
        return this;
    }

    /**
     * Enter FirstName and LastName in Add Employee tab
     *
     * @return
     */
    public EmployeeLeaveProcessPage enterFirstNameAndLastName() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtFirstName, driver);
        String firstName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtFirstName, firstName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtLastName, driver);
        String lastName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtLastName, lastName);
        fullName = firstName + " " + lastName;
        return this;
    }

    /**
     * File Upload
     *
     * @return
     */
    public EmployeeLeaveProcessPage fileUpload() {
        Utilities.getUtilities().waitForElementTobeClickable(btnChooseFile, driver);
        Utilities.getUtilities().uploadFile(btnChooseFile, prop.getProperty("filePath"));
        return this;
    }

    /**
     * Check box for Create Login Detail
     *
     * @return
     */
    public EmployeeLeaveProcessPage checkBoxCreateLoginDetail() {
        Utilities.getUtilities().clickOnElement(checkBoxLogin, driver);
        return this;
    }

    /**
     * Enter Login Detail
     *
     * @return
     */
    public EmployeeLeaveProcessPage enterLoginDetail() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtUserName, driver);
        String userName = Utilities.getUtilities().getFakeName();
        Utilities.getUtilities().sendKey(txtUserName, userName);
        Utilities.getUtilities().waitForVisibilityOfElement(txtPassword, driver);
        Utilities.getUtilities().sendKey(txtPassword, prop.getProperty("password"));
        Utilities.getUtilities().waitForVisibilityOfElement(txtConfirmPassword, driver);
        Utilities.getUtilities().sendKey(txtConfirmPassword, prop.getProperty("confirmPassword"));
        Utilities.getUtilities().clickOnElement(btnSave, driver);
        Thread.sleep(3000);
        return this;
    }

    /**
     * Verify Success Message
     * @return
     */
    public EmployeeLeaveProcessPage verifySuccessMessage(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessage")));
        return this;
    }

    public EmployeeLeaveProcessPage verifySuccessMessageForAdd(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessageForAdd")));
        return this;
    }

    /**
     * Verify Success Message For Assign Leave
     * @return
     */
    public EmployeeLeaveProcessPage verifySuccessMessageForAssignLeave(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessageForAssign")));
        return  this;
    }

    /**
     * Verify Success Message For Delete Record
     * @return
     */
    public EmployeeLeaveProcessPage verifySuccessMessageForDeleteRecord(){
        Utilities.getUtilities().waitForVisibilityOfElement(successMessage,driver);
        Assert.assertTrue(successMessage.getText().trim().equals(prop.getProperty("successMessageForDelete")));
        return this;
    }
    /**
     * Enter Personal Details
     *
     * @return
     */
    public EmployeeLeaveProcessPage enterPersonalDetails() {
        Utilities.getUtilities().clickOnElement(btnSave, driver);
        Utilities.getUtilities().waitForVisibilityOfElement(txtDriverLicenceNumber, driver);
        Utilities.getUtilities().getFakeNum(txtDriverLicenceNumber);
        Utilities.getUtilities().waitForVisibilityOfElement(txtLicenceExpiryDate, driver);
        Utilities.getUtilities().sendKey(txtLicenceExpiryDate, "2022-05-12");

        Utilities.getUtilities().clickOnElement(radioBtnGender, driver);

        Utilities.getUtilities().waitForVisibilityOfElement(selectMaritalStatus, driver);
        Utilities.getUtilities().selectFromDropDown(selectMaritalStatus, "Single");

        Utilities.getUtilities().waitForVisibilityOfElement(selectNationality, driver);
        Utilities.getUtilities().selectFromDropDown(selectNationality, "Afghan");

        Utilities.getUtilities().waitForVisibilityOfElement(txtDateOfBirth, driver);
        Utilities.getUtilities().sendKey(txtDateOfBirth, "1999-01-10");

        Utilities.getUtilities().clickOnElement(btnSave, driver);

        return this;
    }

    /**
     * click on Leave Tab
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnLeave() {
        Utilities.getUtilities().clickOnElement(clickOnLeave, driver);
        return this;
    }

    /**
     * Click on Entitlement Tab
     *
     * @return
     */

    public EmployeeLeaveProcessPage clickOnEntitlement() {
        Utilities.getUtilities().clickOnElement(clickOnEntitlements, driver);
        return this;
    }

    /**
     * Click On Add Leave Entitlement
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickAddLeaveEntitlement() {
        Utilities.getUtilities().clickOnElement(clickAddLeaveEntitlement, driver);
        return this;
    }

    /**
     * Enter Employee Name
     *
     * @return
     */
    public EmployeeLeaveProcessPage enterEmployeeName() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtEmployeeName, driver);
        Thread.sleep(2000);
        Utilities.getUtilities().sendKey(txtEmployeeName, fullName);

       /* Select dropdown = new Select(selectEmployeeName);
        dropdown.selectByValue(fullName);*/
       Utilities.getUtilities().waitForVisibilityOfElement(selectEmployeeName,driver);
       Utilities.getUtilities().waitForElementTobeClickable(selectEmployeeName,driver);
       //Thread.sleep(2000);
        Utilities.getUtilities().clickOnElement(selectEmployeeName, driver);
        return this;
    }

    /**
     * Enter Entitlement
     *
     * @return
     */
    public EmployeeLeaveProcessPage enterEntitlement() {
        Utilities.getUtilities().waitForVisibilityOfElement(txtEntitlement, driver);
        Utilities.getUtilities().sendKey(txtEntitlement, "10");
        Utilities.getUtilities().clickOnElement(btnSave, driver);
        return this;
    }

    /**
     * click on Assign Leave Tab
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnAssignLeave() {
        Utilities.getUtilities().clickOnElement(clickOnAssignLeave, driver);
        return this;
    }

    public EmployeeLeaveProcessPage enterAssignEmployeeName() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtAssignEmployeeName, driver);
        Utilities.getUtilities().waitForElementTobeClickable(txtAssignEmployeeName,driver);
        Utilities.getUtilities().sendKey(txtAssignEmployeeName, fullName);
        Utilities.getUtilities().clickOnElement(txtAssignEmployeeName, driver);
        return this;
    }

    /**
     * Select Leave Type
     *
     * @return
     */
    public EmployeeLeaveProcessPage fillDataForAssignLeave() {
        Utilities.getUtilities().waitForVisibilityOfElement(selectLeaveType, driver);
        Utilities.getUtilities().selectFromDropDown(selectLeaveType, "FMLA US");
        Utilities.getUtilities().waitForVisibilityOfElement(txtAssignFromDate, driver);
        Utilities.getUtilities().waitForVisibilityOfElement(txtLeaveBalance, driver);
        // assert baki check karvanu
       // Assert.assertTrue(txtLeaveBalance.getText().equals(""));
        Utilities.getUtilities().sendKey(txtAssignFromDate, "2020-06-20");
        Utilities.getUtilities().waitForVisibilityOfElement(txtAssignToDate, driver);
        Utilities.getUtilities().sendKey(txtAssignToDate, "2020-06-22");

      //  Utilities.getUtilities().JSClick(btnAssign);
        return this;
    }

    public EmployeeLeaveProcessPage clickOnAssignButton(){
        //Utilities.getUtilities().clickOnElement(btnAssign,driver);
        //Utilities.getUtilities().JSClick(btnAssign);
        Utilities.getUtilities().waitForVisibilityOfElement(btnAssign,driver);
        Utilities.getUtilities().waitForElementTobeClickable(btnAssign,driver);
        Utilities.getUtilities().ActionClassClick(btnAssign);
        return this;
    }
    /**
     * Click on Admin Tab
     *
     * @return
     */

    public EmployeeLeaveProcessPage clickOnAdminTab() {
        Utilities.getUtilities().clickOnElement(tabAdmin, driver);
        return this;
    }

    /**
     * Search Employee Name
     * @return
     * @throws InterruptedException
     */

    public EmployeeLeaveProcessPage txtSearchSystemUserEmployeeName() throws InterruptedException {
        Utilities.getUtilities().waitForVisibilityOfElement(txtSearchSystemUserEmployeeName, driver);
        Thread.sleep(2000);
        Utilities.getUtilities().sendKey(txtSearchSystemUserEmployeeName, fullName);
        Utilities.getUtilities().clickOnElement(selectEmployeeName, driver);
        Utilities.getUtilities().clickOnElement(btnSearch, driver);
        return this;
    }

    /**
     * Click on Check Box
     *
     * @return
     */

    public EmployeeLeaveProcessPage clickOnCheckBox() {
        Utilities.getUtilities().clickOnElement(CheckBoxRow,driver);
       // Utilities.getUtilities().JSClick(CheckBoxRow);
        return this;
    }

    /**
     * Click On Delete Button
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnDeleteButton() {
        Utilities.getUtilities().clickOnElement(btnDelete, driver);
        return this;
    }

    /**
     * Click On Dialog Box
     *
     * @return
     */
    public EmployeeLeaveProcessPage clickOnDialogBox() {
        Utilities.getUtilities().clickOnElement(dialogButton, driver);
        return this;
    }

}