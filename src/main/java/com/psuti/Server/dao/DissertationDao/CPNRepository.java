package com.psuti.Server.dao.DissertationDao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.psuti.Server.entity.DissertationEntityes.*;
import java.util.UUID;

public interface CPNRepository extends JpaRepository <CPN, UUID> {
}
