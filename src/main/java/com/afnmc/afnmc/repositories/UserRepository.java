package com.afnmc.afnmc.repositories;

import com.afnmc.afnmc.models.documets.UserDocument;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findByEmail(String email);
}
