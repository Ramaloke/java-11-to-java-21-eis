package my.playground.Java11ToJava21.records;

import java.text.SimpleDateFormat;
import java.util.Date;

public record PersonNameAndDateRecord(String name, Date birthDate) {
    public PersonNameAndDateRecord {
        if(name == null || birthDate == null) {
            throw new IllegalArgumentException("name and birthDate cannot be null");
        }
    }

    //You can override getters
    @Override
    public Date birthDate() {
        return birthDate;
    }

    //You can extend records with new methods
    public String getFormattedBirthDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(birthDate);
    }

    //You can override toString() method as well as equals() and hashCode()
    @Override
    public String toString() {
        return String.format("[Name: %s; Birth Date: %s]", name, getFormattedBirthDate());
    }
}