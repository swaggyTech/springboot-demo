package com.demo.ormjpa.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *     实体通用父类</>
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 15:42
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class AbstractAuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time",nullable = false,updatable = false)
    @CreatedDate
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_time",nullable = false)
    @LastModifiedDate
    private Date lastUpdateTime;
}
