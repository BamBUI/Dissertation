package com.psuti.Server.dao.DissertationDao;

import com.psuti.Server.entity.DissertationEntityes.SupportPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SupportPartRepository extends JpaRepository<SupportPart, UUID> {
}