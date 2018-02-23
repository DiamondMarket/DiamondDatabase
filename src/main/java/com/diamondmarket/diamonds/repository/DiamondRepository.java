package com.diamondmarket.diamonds.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.diamondmarket.diamonds.model.Supplier;

public interface DiamondRepository extends MongoRepository<Supplier, String> {
	
}
