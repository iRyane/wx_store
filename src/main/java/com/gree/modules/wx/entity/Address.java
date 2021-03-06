package com.gree.modules.wx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yan
 * @since 2019-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("wx_address")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 收货人
     */
    @TableField("receiver")
    private String receiver;

    /**
     * 收货人号码
     */
    @TableField("receiver_mobile")
    private String receiverMobile;

    /**
     * 收货地址
     */
    @TableField("address")
    private String address;

    /**
     * 创建者ID
     */
    @TableField("create_user_id")
    @JsonIgnore
    private Long createUserId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonIgnore
    private LocalDateTime createTime;


}
