package cn.hsj.common.entity;

import java.util.Date;
/**
 * 测试自己定义实体的方式demo
 * @author hsj
 * @date 2017-06-15
 */
public class TSysDictExtend {
//public class TSysDictExtend {
   /**
	 * 
	 */
   private Integer id;
   
   private Short is_delete;
   
   private String dict_code;
   
   private String dict_name;
   
   private Integer dict_item_code;
   
   private String dict_item_label;
   
   private String dict_item_string;
   
   private Integer sort;
   
   private Short status;
   
   private String creator;
   
   private Date create_time;
   
   private Date update_time;
   
   private String remark;
   

public TSysDictExtend() {
	super();
}



public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public Short getIs_delete() {
	return is_delete;
}


public void setIs_delete(Short is_delete) {
	this.is_delete = is_delete;
}


public String getDict_code() {
	return dict_code;
}


public void setDict_code(String dict_code) {
	this.dict_code = dict_code;
}


public String getDict_name() {
	return dict_name;
}


public void setDict_name(String dict_name) {
	this.dict_name = dict_name;
}


public Integer getDict_item_code() {
	return dict_item_code;
}


public void setDict_item_code(Integer dict_item_code) {
	this.dict_item_code = dict_item_code;
}


public String getDict_item_label() {
	return dict_item_label;
}


public void setDict_item_label(String dict_item_label) {
	this.dict_item_label = dict_item_label;
}


public String getDict_item_string() {
	return dict_item_string;
}


public void setDict_item_string(String dict_item_string) {
	this.dict_item_string = dict_item_string;
}


public Integer getSort() {
	return sort;
}


public void setSort(Integer sort) {
	this.sort = sort;
}


public Short getStatus() {
	return status;
}


public void setStatus(Short status) {
	this.status = status;
}


public String getCreator() {
	return creator;
}


public void setCreator(String creator) {
	this.creator = creator;
}





public Date getCreate_time() {
	return create_time;
}


public void setCreate_time(Date create_time) {
	this.create_time = create_time;
}


public Date getUpdate_time() {
	return update_time;
}


public void setUpdate_time(Date update_time) {
	this.update_time = update_time;
}


public String getRemark() {
	return remark;
}


public void setRemark(String remark) {
	this.remark = remark;
}



   
}
