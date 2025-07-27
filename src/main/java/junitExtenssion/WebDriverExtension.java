package junitExtenssion;

import drivers.DriverManager;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverExtension implements BeforeTestExecutionCallback,AfterEachCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Initializing WebDriver...");
        DriverManager.getDriver();
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        System.out.println("Quitting WebDriver...");
        DriverManager.quitDriver();
    }

}