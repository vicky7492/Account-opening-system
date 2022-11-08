package com.accountOpening.repository;

import com.accountOpening.model.ClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<ClientDetails,Long> {
}
