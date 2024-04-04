package my.playground.Java11ToJava21.db.dao;

import my.playground.Java11ToJava21.db.domain.Gender;
import my.playground.Java11ToJava21.db.dto.PersonNameAndDateDto;
import my.playground.Java11ToJava21.records.PersonNameAndDateRecord;

import java.util.List;

public interface PersonDao {
    List<PersonNameAndDateDto> findByGender(Gender gender);

    List<PersonNameAndDateRecord> findPersonRecordsByGender(Gender gender);
}
