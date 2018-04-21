package com.example.oauthserver.domain.common;


import com.example.oauthserver.domain.contstant.Constant;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class ModifiedAuditorAware {
    @PrePersist
    @PreUpdate
    public void setCreated(Modified modified){
        modified.setModifiedAt(LocalDateTime.now());
        modified.setModifiedBy(Constant.SYSTEM);
    }
}
