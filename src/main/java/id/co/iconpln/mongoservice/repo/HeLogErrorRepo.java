package id.co.iconpln.mongoservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import id.co.iconpln.mongoservice.entities.HeLogError;

@Repository
public interface HeLogErrorRepo extends MongoRepository<HeLogError, String> {

}
