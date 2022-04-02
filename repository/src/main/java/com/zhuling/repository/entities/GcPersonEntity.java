package com.zhuling.repository.entities;


import com.zhuling.common.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 人员信息表
 *
 * @Date 2022-04-02
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "gc_person")
public class GcPersonEntity extends AbstractEntity {


    /**
     * 人员记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 人员唯一编号
     */
    @Column(name = "person_no")
    private String personNo;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 身份证件号码
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 身份证件类型 01=居民身份证
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 出生日期：YYYY-MM-DD
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 性别 男|女
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 身份证有效期年月日或长期
     */
    @Column(name = "id_expiry_date")
    private String idExpiryDate;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 实名认证 0=未认证 1=已认证 2=认证失败
     */
    @Column(name = "auth_name_state")
    private Integer authNameState;

    /**
     * 实名认证时间
     */
    @Column(name = "auth_name_time")
    private Date authNameTime;

    /**
     * 实名认证备注
     */
    @Column(name = "auth_name_remark")
    private String authNameRemark;

    /**
     * 信息来源:1=API=开放接口,2=WEB=商户后台,3=H5=用户H5,4=WXAPP=微信小程序,5=BOSS=运营管理平台
     */
    @Column(name = "source_from")
    private Integer sourceFrom;

    @Builder
    public GcPersonEntity(String status, Date createDate, String createBy, Date updateDate, String updateBy, String remarks, Long id, String personNo, String name, String idCardNo, String idCardType, Date birthday, String sex, String idExpiryDate, String address, Integer authNameState, Date authNameTime, String authNameRemark, Integer sourceFrom) {
        super(status, createDate, createBy, updateDate, updateBy, remarks);
        this.id = id;
        this.personNo = personNo;
        this.name = name;
        this.idCardNo = idCardNo;
        this.idCardType = idCardType;
        this.birthday = birthday;
        this.sex = sex;
        this.idExpiryDate = idExpiryDate;
        this.address = address;
        this.authNameState = authNameState;
        this.authNameTime = authNameTime;
        this.authNameRemark = authNameRemark;
        this.sourceFrom = sourceFrom;
    }

}
