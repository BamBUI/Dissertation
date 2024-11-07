package com.psuti.Server.dao.DissertationDao;

import com.psuti.Server.entity.DissertationEntityes.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InformationRepository extends JpaRepository<Information, UUID> {
}
