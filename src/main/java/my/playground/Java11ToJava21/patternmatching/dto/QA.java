package my.playground.Java11ToJava21.patternmatching.dto;

public class QA extends Employee {
    private boolean automationTesting;

    public QA(String name, boolean automationTesting) {
        super(name);
        this.automationTesting = automationTesting;
    }

    public boolean isAutomationTesting() {
        return automationTesting;
    }

    public void setAutomationTesting(boolean automationTesting) {
        this.automationTesting = automationTesting;
    }

    public String toString() {
        return "Name: " + getName() + "; automation testing: " + isAutomationTesting();
    }

}
