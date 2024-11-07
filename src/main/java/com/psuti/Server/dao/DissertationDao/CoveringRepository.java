package com.psuti.Server.dao.DissertationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.psuti.Server.entity.DissertationEntityes.*;
import java.util.UUID;

public interface CoveringRepository extends JpaRepository<Covering, UUID> {
}
