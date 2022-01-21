package id.co.iconpln.mongoservice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.iconpln.mongoservice.entities.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, Long> {

	@Query("{ 'name' : ?0 }")
	List<Employee> findByName(String name);

	@Query("{ 'name' : {$regex:?0}}")
	List<Employee> findByLikesName(String name);

}
