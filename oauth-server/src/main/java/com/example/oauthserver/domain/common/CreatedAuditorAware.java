package com.example.oauthserver.domain.common;


import com.example.oauthserver.domain.contstant.Constant;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class CreatedAuditorAware {

    @PrePersist
    public void setCreated(Created created){
        created.setCreatedAt(LocalDateTime.now());
        created.setCreatedBy(Constant.SYSTEM);
    }
}
