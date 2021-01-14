package com.example.springbootthymeleaf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@TableName("log")
@Data
// 所有参赛构造方法
@AllArgsConstructor
// 无参数构造方法
@NoArgsConstructor
public class Log extends Model<Log> implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    @Pattern(regexp = "^[1-9]\\d*|0$",message = "只能为正整数")
    private Integer id;
    @NotBlank(message = "标题不能为空")
    private String title;
    private String url;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date end_time;
    private String username;
    private String exception;
    private Integer roleid;


//    public Integer getRoleid() {
//        return roleid;
//    }
//
//    public void setRoleid(Integer roleid) {
//        this.roleid = roleid;
//    }



    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", end_time=" + end_time +
                ", username='" + username + '\'' +
                ", exception='" + exception + '\'' +
                '}';
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//
//    public Date getEnd_time() {
//        return end_time;
//    }
//
//    public void setEnd_time(Date end_time) {
//        this.end_time = end_time;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getException() {
//        return exception;
//    }
//
//    public void setException(String exception) {
//        this.exception = exception;
//    }

}
