package com.psuti.Server.dao.DissertationDao;
import com.psuti.Server.entity.DissertationEntityes.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdditionalPartRepository extends JpaRepository<AdditionalPart, UUID> {
}