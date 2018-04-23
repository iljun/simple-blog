package com.example.resource.domain.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({ CreatedAuditorAware.class})
public class Created {

    @Column
    private LocalDateTime createdAt;

    @Column
    private String createdBy;
}
