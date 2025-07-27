package btl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Base_btl {
        protected WebDriver driver;
        public Base_btl(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver,this);    }
    }

