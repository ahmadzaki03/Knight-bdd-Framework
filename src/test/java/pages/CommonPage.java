package pages;
import org.openqa.selenium.By;
public class CommonPage {
    public final static By pageTitle = By.xpath("//mat-toolbar/span[1]");

    //Static methods that returns By Object.
    public static By getLinkLocator(String linkText) {
        return By.partialLinkText(linkText);
    }
}
