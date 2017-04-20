package com.test.framework.common.utils.reporter;

/**
 * @author hong.lin
 * @description
 * @date 2017/4/20.
 */
public class TestCase {
    private String className;
    private String caseName;
    private String description;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "className='" + className + '\'' +
                ", caseName='" + caseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
