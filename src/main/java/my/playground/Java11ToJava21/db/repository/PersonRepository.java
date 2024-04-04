package my.playground.Java11ToJava21.db.repository;

import my.playground.Java11ToJava21.db.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
