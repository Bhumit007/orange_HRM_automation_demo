package OrangeHRMTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Reporter.log;

    @Listeners({OrangeHRMTest.TestListener.class})
    @Epic("Regression Test Suite - Login Details")
    public class EmployeeLeaveProcessTest extends BaseTest{
        @Step("Success Message: ")
        public void logToReport(String message) {
            log(message);
        }

        @Test(priority = 0)
        @Severity(SeverityLevel.NORMAL)
        @Step("TestCase_001 - verify login successfully")
        public void orangeHRM_001_verifyLoginSuccessfully() {
            try {
                employeeLeaveProcessPage.adminLogin().clickOnLoginButton().verifyHomePage();
                logToReport("User successfully click on Login button.");
            } catch (Exception |AssertionError E) {
                System.out.println("User Could not click on login button or verify validation message.");
                Assert.fail("User Could not click on login in button or verify validation message.");
            }
        }

        @Test(priority = 1)
        @Severity(SeverityLevel.NORMAL)
        @Step("TestCase_002 - verify to fill all mandatory field in employee tab")
        public void orangeHRM_002_verifyEditEmployeeDetailsTab() {
            try {
                employeeLeaveProcessPage.clickOnPIM().clickOnAddEmployee();
                employeeLeaveProcessPage.enterFirstNameAndLastName().fileUpload().checkBoxCreateLoginDetail();
                employeeLeaveProcessPage.enterLoginDetail().enterPersonalDetails();
                employeeLeaveProcessPage.verifySuccessMessage();
                logToReport("User successfully enter all mandatory field in employee tab.");
            } catch (Exception |AssertionError E) {
                System.out.println("User Could not enter all mandatory field in employee tab or verify validation message.");
                Assert.fail("User Could not enter all mandatory field in employee tab or verify validation message.",E);
            }
        }

        @Test(priority = 2)
        @Severity(SeverityLevel.NORMAL)
        @Step("TestCase_003 - verify to Add Entitlement")
        public void orangeHRM_003_verifyToAddEmployeeEntitlement() {
            try {
                employeeLeaveProcessPage.clickOnLeave().clickOnEntitlement().clickAddLeaveEntitlement().enterEmployeeName().enterEntitlement();
                employeeLeaveProcessPage.verifySuccessMessageForAdd();
                logToReport("User successfully verify Add Entitlement.");
            } catch (Exception |AssertionError E) {
                System.out.println("User Could not enter enter all mandatory field in Add Entitlement tab or verify validation message.");
                Assert.fail("User Could not enter all enter all mandatory field in Add Entitlement tab or verify validation message.",E);
            }
        }

        @Test(priority = 3)
        @Severity(SeverityLevel.NORMAL)
        @Step("TestCase_004 - verify to Assigned Leave")
        public void orangeHRM_004_verifyAssignedEmployeeLeave() {
            try {
                employeeLeaveProcessPage.clickOnLeave().clickOnAssignLeave().enterAssignEmployeeName().fillDataForAssignLeave().clickOnAssignButton();
                employeeLeaveProcessPage.verifySuccessMessageForAssignLeave();
                logToReport("User assign leave is successfully verify.");
            } catch (Exception |AssertionError E) {
                System.out.println("User assign leave not verify or verify validation message.");
                Assert.fail("User assign leave not verify or verify validation message.",E);
            }
        }

        @Test(priority = 4)
        @Severity(SeverityLevel.NORMAL)
        @Step("TestCase_005 - verify Delete Employee By Admin")
        public void orangeHRM_005_verifyDeleteEmployee() {
            try {
                Thread.sleep(2000);
                employeeLeaveProcessPage.clickOnAdminTab().txtSearchSystemUserEmployeeName().clickOnCheckBox().clickOnDeleteButton().clickOnDialogBox();
                employeeLeaveProcessPage.verifySuccessMessageForDeleteRecord();
                logToReport("User successfully delete from database.");
            } catch (Exception |AssertionError E) {
                System.out.println("User could not delete from database or verify validation message.");
                Assert.fail("User could not delete from database or verify validation message.",E);
            }
        }

    }
