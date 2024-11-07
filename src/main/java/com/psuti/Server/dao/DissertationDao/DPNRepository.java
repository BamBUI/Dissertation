package com.psuti.Server.dao.DissertationDao;

import com.psuti.Server.entity.DissertationEntityes.AdditionalPart;
import com.psuti.Server.entity.DissertationEntityes.DPN;
import org.springframework.data.jpa.repository.*;

import java.util.UUID;

public interface DPNRepository extends JpaRepository<DPN, UUID> {
}
