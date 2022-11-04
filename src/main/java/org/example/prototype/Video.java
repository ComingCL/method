package org.example.prototype;

import java.util.Date;

/**
 * @Author: ComingLiu
 * @Date: 2022/11/4 0:41
 */

public class Video implements Cloneable{
    private String name;
    private Date createTime;

    @Override
    protected Object clone() throws CloneNotSupportedException{
        /*
        深克隆, 或者序列化反序列化
        Video v = (Video) super.clone();
        v.createTime = (Date) this.createTime.clone();// 将这个对象的属性也进行克隆
         */
        return super.clone();
    }
    public Video(){
    }

    public Video(String name, Date createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
