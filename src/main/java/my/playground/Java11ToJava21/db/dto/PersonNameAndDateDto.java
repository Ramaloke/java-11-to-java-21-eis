package my.playground.Java11ToJava21.db.dto;

import java.util.Date;
import java.util.Objects;

public class PersonNameAndDateDto {

    private final String name;
    private final Date birthDate;

    public PersonNameAndDateDto(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonNameAndDateDto that = (PersonNameAndDateDto) o;
        return Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

    @Override
    public String toString() {
        return "PersonNameAndDateDto{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
