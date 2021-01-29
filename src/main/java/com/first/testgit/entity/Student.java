package com.first.testgit.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:jiaxingxu
 **/

@TableName("student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

     @TableField("s_id")
     private  String s_id;

     private  String sName;

     private  String sBirth;

     public String gets_id() {
          return s_id;
     }

     public void set_id(String s_id) {
          this.s_id = s_id;
     }

     public String getsName() {
          return sName;
     }

     public void setsName(String sName) {
          this.sName = sName;
     }

     public String getsBirth() {
          return sBirth;
     }

     public void setsBirth(String sBirth) {
          this.sBirth = sBirth;
     }

     public String getsSex() {
          return sSex;
     }

     public void setsSex(String sSex) {
          this.sSex = sSex;
     }

     private  String  sSex;

}
