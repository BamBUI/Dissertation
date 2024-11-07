package com.psuti.Server.dao.DissertationDao;

import com.psuti.Server.entity.DissertationEntityes.SpecialWire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialWireRepository extends JpaRepository<SpecialWire, UUID> {
}
