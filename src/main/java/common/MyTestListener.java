package common;

import io.restassured.RestAssured;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class MyTestListener implements ISuiteListener, ITestListener {

    private Logger log = MyLogger.log;

    public void onStart(ISuite iSuite) {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public void onFinish(ISuite iSuite) {
        log.info("Finished running all the tests.");
        log.info("============================");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Starting test " + iTestResult.getName());
        log.info("============================" );
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test " + iTestResult.getName() + " PASSED");
        log.info("============================" );
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error("Testcase " + iTestResult.getName() + "  FAILED");
        log.info("============================" );
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.warn("Testcase " + iTestResult.getName() + " SKIPPED");
        log.info("============================" );
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}