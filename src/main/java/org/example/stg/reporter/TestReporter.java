package org.example.stg.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.slf4j.Slf4j;
import org.example.stg.util.WebDriverHelper;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.example.stg.constant.Path.PATH_TO_REPORT;

@Slf4j
public class TestReporter implements BeforeAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {
    protected static ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(PATH_TO_REPORT + "TestReport.html");
    protected ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) {
        //spark.config().setTheme(Theme.DARK);
        extent.attachReporter(spark);
        context.getStore(ExtensionContext.Namespace.GLOBAL).put("TestReport", new CustomAfterSuite());
        test = extent.createTest(context.getDisplayName());
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        test.log(Status.INFO, context.getDisplayName() + " - started");
        test.createNode(context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (!context.getExecutionException().isPresent()) {
            test.pass(context.getDisplayName() + " - passed");
        } else {
            test.fail(context.getExecutionException().get().getLocalizedMessage());
            test.addScreenCaptureFromPath("./" + WebDriverHelper.takeScreenshot(), context.getDisplayName());
        }
    }

    private static class CustomAfterSuite implements ExtensionContext.Store.CloseableResource {
        @Override
        public void close() {
            //After all tests run hook.
            //Any additional desired action goes here
            extent.flush();
            log.info("----- TEST REPORT CREATED -----");
        }
    }
}
