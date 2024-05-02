package com.hello.model.studio.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("studio_post")
public class StudioPost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 自媒体用户ID
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 内容
     */
    @TableField("content")
    private String content;
    /**
     * 频道ID
     */
    @TableField("channel_id")
    private Integer channelId;
    /**
     * 标签
     */
    @TableField("labels")
    private String labels;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;
    /**
     * 提交时间
     */
    @TableField("submited_time")
    private Date submitedTime;
    /**
     * 状态
     */
    private Short status;
    /**
     *发布时间
     */
    private Date publishTime;
    /**
     * 原因
     */
    private String reason;
    /**
     * 发布的ID
     */
    private Long postId;
    /**
     * 图片
     */
    private String images;
    /**
     * 状态
     */
    private Short enables;
}