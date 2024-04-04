package my.playground.Java11ToJava21.records;

import com.github.javafaker.Faker;
import my.playground.Java11ToJava21.db.dao.PersonDao;
import my.playground.Java11ToJava21.db.domain.Gender;
import my.playground.Java11ToJava21.db.domain.Person;
import my.playground.Java11ToJava21.db.dto.PersonNameAndDateDto;
import my.playground.Java11ToJava21.db.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RecordsTest {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonDao personDao;

    private final Faker faker = new Faker();

    @Test
    public void retrieveFemalePersonsByGender() {
        //given
        Person testFemalePerson = new Person("Sarah", "full address", faker.date().birthday(), Gender.FEMALE);
        repository.save(testFemalePerson);

        //when
        List<PersonNameAndDateDto> femalePeopleDtoList = personDao.findByGender(Gender.FEMALE);

        //then
        assertEquals(1, femalePeopleDtoList.size());
        PersonNameAndDateDto resultDto = femalePeopleDtoList.get(0);
        assertEquals(testFemalePerson.getName(), resultDto.getName());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").format(testFemalePerson.getBirthDate()), resultDto.getBirthDate().toString());
    }

    @Test
    public void retrieveMalePersonRecordsByGender() {
        PersonNameAndDateRecord record = new PersonNameAndDateRecord("Name", new Date());
        System.out.println("Name: " + record.name() + "; Birth date: " + record.birthDate());

        //given
        Person testMalePerson = new Person("John Doe", "full address", faker.date().birthday(), Gender.MALE);
        repository.save(testMalePerson);

        //when
        List<PersonNameAndDateRecord> malePeopleRecords = personDao.findPersonRecordsByGender(Gender.MALE);

        //then
        assertEquals(1, malePeopleRecords.size());
        PersonNameAndDateRecord resultDto = malePeopleRecords.get(0);
        assertEquals(testMalePerson.getName(), resultDto.name());
        assertEquals(new SimpleDateFormat("yyyy-MM-dd").format(testMalePerson.getBirthDate()), resultDto.birthDate().toString());
    }

    private List<Person> initPersons(int numberOfPersons) {
        return Stream.generate(this::createRandomPerson)
                .limit(numberOfPersons)
                .toList();
    }

    private Person createRandomPerson() {
        String firstName = faker.name().firstName();
        Date birthDate = faker.date().birthday();
        String fullAddress = faker.address().fullAddress();

        Gender[] genders = Gender.values();
        int genderIndex = new Random().nextInt(genders.length);

        return new Person(firstName, fullAddress, birthDate, genders[genderIndex]);
    }
}
