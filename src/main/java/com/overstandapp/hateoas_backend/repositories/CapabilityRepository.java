package com.overstandapp.hateoas_backend.repositories;

import com.overstandapp.hateoas_backend.domain.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability, Long> {
}
