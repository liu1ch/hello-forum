package com.hello.model.post.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("post_config")
public class PostConfig implements Serializable {

    @TableId(value = "id",type = IdType.ASSIGN_ID )
    private Long id;

    /**
     * 评论状态 0.不可评论 1.精选  2.可以随意评论
     */
    @TableField("comment_status")
    private Short commentStatus;

    /**
     * 是否下架
     */
    @TableField("is_down")
    private Boolean down;

    /**
     * 是否删除
     */
    @TableField("is_delete")
    private Boolean delete;

}
