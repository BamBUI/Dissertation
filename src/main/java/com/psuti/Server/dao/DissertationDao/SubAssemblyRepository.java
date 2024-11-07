package com.psuti.Server.dao.DissertationDao;

import com.psuti.Server.entity.DissertationEntityes.SubAssembly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubAssemblyRepository extends JpaRepository<SubAssembly, UUID> {
}
