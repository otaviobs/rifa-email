package br.com.rifa.email.repositories;

import br.com.rifa.email.models.EmailModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<EmailModel, String> {
}
