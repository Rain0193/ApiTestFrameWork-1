package com.test.framework.common.utils.reporter;

import java.util.List;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/20.
 */
public class TestSuite {
    private String urlPath;
    private boolean isCompleted;
    private List<TestCase> testCaseList;

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public void setTestCaseList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }

    @Override
    public String toString() {
        return "TestSuite{" +
                "urlPath='" + urlPath + '\'' +
                ", isCompleted=" + isCompleted +
                ", testCaseList=" + testCaseList +
                '}';
    }
}
