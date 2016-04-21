package com.applewjg.domain;

import javax.persistence.*;

/**
 * Created by baidu on 16/4/12.
 */
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long pid; //用户帖子post_ID

    @Column(nullable = false)
    private String subject; //标题

    @Column(nullable = false, columnDefinition = "mediumtext")
    private String content = ""; //内容

    @Column(nullable = false, columnDefinition = "bigint(20) not null default '0'")
    private Long createtime = 0L; //创建时间

    @Column(nullable = false, columnDefinition = "bigint(20) not null default '0'")
    private Long modifytime = 0L; //修改时间

    @Column(length = 15, nullable = false)
    private String useip = ""; //发帖IP

    @Column(nullable = false, columnDefinition = "mediumint(8) not null default '0'")
    private Integer status = 0;

    public Blog() {}

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getModifytime() {
        return modifytime;
    }

    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }

    public String getUseip() {
        return useip;
    }

    public void setUseip(String useip) {
        this.useip = useip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
