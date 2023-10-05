package pages;

import org.openqa.selenium.By;
public class AccountsPage {

        public final static By TABLE_ROWS = By.xpath("//table/tbody/tr");

        public final static By ITEM_PER_PAGE_SELECT = By.xpath("//mat-paginator//mat-select");

        public final static By ITEM_PER_PAGE_OPTIONS = By.xpath("//mat-option/span");
        public final static By ACCOUNT_TABLE_HEADER_COLUMNS = By.xpath("//table/thead/tr/th");
    }
