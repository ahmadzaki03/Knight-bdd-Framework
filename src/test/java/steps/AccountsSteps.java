package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.fedcm.model.Account;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountsPage;
import utility.SeleniumUtility;
import java.util.List;
public class AccountsSteps extends SeleniumUtility {
    @Then("Validate accounts table have {int} rows")
    public void validateAccountTableRows(int expectedRows) {
        List<WebElement>  tableRowsElements = getListOfElements(AccountsPage.TABLE_ROWS);
        Assert.assertEquals("Validate Account Table row " ,
                expectedRows,
                tableRowsElements.size());
    }

    //TODO Failed due to stale element while calling step multiple time
    @When("change item per page to {string}")
    public void changeItemPerPage(String itemPerPage) {
        //Click to open the dropdown
        clickOnElement(AccountsPage.ITEM_PER_PAGE_SELECT);
        selectFromDropDown(AccountsPage.ITEM_PER_PAGE_OPTIONS, itemPerPage);
    }

    @Then("Validate Accounts table headers")
    public void validateAccountTableHeaders(DataTable dataTable) {
        //Covert datatable to List
        List<List<String>> dataAsList = dataTable.asLists();
        List<String> expectedHeaders = dataAsList.get(0);

        List<WebElement> columnElements = getListOfElements(AccountsPage.ACCOUNT_TABLE_HEADER_COLUMNS);

        for (int i = 0; i < expectedHeaders.size(); i ++ ) {
            String expectedHeader = expectedHeaders.get(i);
            String actualHeader = columnElements.get(i).getText();

            Assert.assertEquals("Validate Accounts Table Header" ,
                    expectedHeader,
                    actualHeader);
        }
    }
}
