package com.application.first.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.first.domain.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, String> {

}
