package my.playground.Java11ToJava21.db.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import my.playground.Java11ToJava21.db.dao.PersonDao;
import my.playground.Java11ToJava21.db.domain.Gender;
import my.playground.Java11ToJava21.db.dto.PersonNameAndDateDto;
import my.playground.Java11ToJava21.records.PersonNameAndDateRecord;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public class PersonJpaDao implements PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    private static String FIND_BY_GENDER =
            "select new " + PersonNameAndDateDto.class.getName() + "(p.name, p.birthDate) " +
                    "from Person p " +
                    "where p.gender = :gender";

    private static String FIND_RECORDS_BY_GENDER =
            "select new " + PersonNameAndDateRecord.class.getName() + "(p.name, p.birthDate) " +
                    "from Person p " +
                    "where p.gender = :gender";

    @Override
    public List<PersonNameAndDateDto> findByGender(Gender gender) {
        Assert.notNull(gender, "gender cannot be null");
        TypedQuery<PersonNameAndDateDto> query = entityManager.createQuery(FIND_BY_GENDER, PersonNameAndDateDto.class)
                .setParameter("gender", gender);
        return query.getResultList();
    }

    @Override
    public List<PersonNameAndDateRecord> findPersonRecordsByGender(Gender gender) {
        Assert.notNull(gender, "gender cannot be null");
        TypedQuery<PersonNameAndDateRecord> query = entityManager.createQuery(FIND_RECORDS_BY_GENDER, PersonNameAndDateRecord.class)
                .setParameter("gender", gender);
        return query.getResultList();
    }
}
