package my.playground.Java11ToJava21.patternmatching.dto;

public class Developer extends Employee {
    private String mainProgrammingLanguage;

    public Developer(String name, String mainProgrammingLanguage) {
        super(name);
        this.mainProgrammingLanguage = mainProgrammingLanguage;
    }

    public String getMainProgrammingLanguage() {
        return mainProgrammingLanguage;
    }

    public void setMainProgrammingLanguage(String mainProgrammingLanguage) {
        this.mainProgrammingLanguage = mainProgrammingLanguage;
    }

    public String toString() {
        return "Name: " + getName() + "; main programming language: " + getMainProgrammingLanguage();
    }
}
