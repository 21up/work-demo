package com.wen.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created by 21up on 2020/9/26
 */
@Data
public class User {
    @TableId(value = "ID",type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
