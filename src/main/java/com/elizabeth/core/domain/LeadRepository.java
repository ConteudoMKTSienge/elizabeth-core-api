package com.elizabeth.core.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends MongoRepository<Lead, String> {

	Lead findByFingerprintId(String fingerprintId);
	Lead findByEmail(String email);

}
