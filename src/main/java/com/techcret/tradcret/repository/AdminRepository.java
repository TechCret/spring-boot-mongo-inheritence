package com.techcret.tradcret.repository;

import com.techcret.tradcret.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
}
