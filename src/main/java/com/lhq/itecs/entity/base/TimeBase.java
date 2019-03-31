package com.lhq.itecs.entity.base;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;


/**
 * 創建時間，更新時間。但是創建時間不能更改，更新時間可以進行更改，并且是樂觀鎖
 * */
@Data
@MappedSuperclass
public class TimeBase {
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    protected Timestamp createTime;

    @Version
    @UpdateTimestamp
    @Column(nullable = false)
    protected Timestamp updateTime;
}
