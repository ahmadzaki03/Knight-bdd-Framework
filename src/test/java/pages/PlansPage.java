package pages;
import org.openqa.selenium.By;
public class PlansPage {
    public final static By PLANS_SECTION_TITLE = By.xpath("//app-plans-list/mat-card/mat-card-title");

    public final static By TABLE_ROW_LOCATOR = By.xpath("//table/tbody/tr");
    public final static By PLAN_EXPIRED_COLUMN = By.xpath("//table/tbody/tr/td[6]");

    public final static By PLAN_TABLE_HEADER_COLUMNS = By.xpath("//table/thead/tr/th");

    public static By getTablePlanTypeColumn(int row) {
        return By.xpath("//table/tbody/tr["+row+"]/td[1]");
    }

    public static By getTableCreatedByColumn(int row) {
        return By.xpath("//table/tbody/tr["+row+"]/td[4]");
    }

    public static By getTableIsExpiredColumn(int row) {
        return By.xpath("//table/tbody/tr["+row+"]/td[6]");
    }
}
