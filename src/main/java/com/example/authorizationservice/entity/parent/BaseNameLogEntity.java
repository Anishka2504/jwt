package com.example.authorizationservice.entity.parent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseNameLogEntity extends BaseNameEntity{

    @CreatedDate
    @Column(name = "date_creation", updatable = false)
    private Date dateCreation;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Date lastModified;

    @Version
    private int version;


}
