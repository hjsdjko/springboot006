package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 工作信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@TableName("gongzuoxinxi")
public class GongzuoxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzuoxinxiEntity() {
		
	}
	
	public GongzuoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 岗位名称
	 */
					
	private String gangweimingcheng;
	
	/**
	 * 工作类型
	 */
					
	private String gongzuoleixing;
	
	/**
	 * 招聘人数
	 */
					
	private String zhaopinrenshu;
	
	/**
	 * 专业要求
	 */
					
	private String zhuanyeyaoqiu;
	
	/**
	 * 学历要求
	 */
					
	private String xueliyaoqiu;
	
	/**
	 * 薪资待遇
	 */
					
	private String xinzidaiyu;
	
	/**
	 * 工作时间
	 */
					
	private String gongzuoshijian;
	
	/**
	 * 岗位详情
	 */
					
	private String gangweixiangqing;
	
	/**
	 * 企业名称
	 */
					
	private String qiyemingcheng;
	
	/**
	 * 企业地址
	 */
					
	private String qiyedizhi;
	
	/**
	 * 联系电话
	 */
					
	private String lianxidianhua;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：岗位名称
	 */
	public void setGangweimingcheng(String gangweimingcheng) {
		this.gangweimingcheng = gangweimingcheng;
	}
	/**
	 * 获取：岗位名称
	 */
	public String getGangweimingcheng() {
		return gangweimingcheng;
	}
	/**
	 * 设置：工作类型
	 */
	public void setGongzuoleixing(String gongzuoleixing) {
		this.gongzuoleixing = gongzuoleixing;
	}
	/**
	 * 获取：工作类型
	 */
	public String getGongzuoleixing() {
		return gongzuoleixing;
	}
	/**
	 * 设置：招聘人数
	 */
	public void setZhaopinrenshu(String zhaopinrenshu) {
		this.zhaopinrenshu = zhaopinrenshu;
	}
	/**
	 * 获取：招聘人数
	 */
	public String getZhaopinrenshu() {
		return zhaopinrenshu;
	}
	/**
	 * 设置：专业要求
	 */
	public void setZhuanyeyaoqiu(String zhuanyeyaoqiu) {
		this.zhuanyeyaoqiu = zhuanyeyaoqiu;
	}
	/**
	 * 获取：专业要求
	 */
	public String getZhuanyeyaoqiu() {
		return zhuanyeyaoqiu;
	}
	/**
	 * 设置：学历要求
	 */
	public void setXueliyaoqiu(String xueliyaoqiu) {
		this.xueliyaoqiu = xueliyaoqiu;
	}
	/**
	 * 获取：学历要求
	 */
	public String getXueliyaoqiu() {
		return xueliyaoqiu;
	}
	/**
	 * 设置：薪资待遇
	 */
	public void setXinzidaiyu(String xinzidaiyu) {
		this.xinzidaiyu = xinzidaiyu;
	}
	/**
	 * 获取：薪资待遇
	 */
	public String getXinzidaiyu() {
		return xinzidaiyu;
	}
	/**
	 * 设置：工作时间
	 */
	public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
	}
	/**
	 * 获取：工作时间
	 */
	public String getGongzuoshijian() {
		return gongzuoshijian;
	}
	/**
	 * 设置：岗位详情
	 */
	public void setGangweixiangqing(String gangweixiangqing) {
		this.gangweixiangqing = gangweixiangqing;
	}
	/**
	 * 获取：岗位详情
	 */
	public String getGangweixiangqing() {
		return gangweixiangqing;
	}
	/**
	 * 设置：企业名称
	 */
	public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
	}
	/**
	 * 获取：企业名称
	 */
	public String getQiyemingcheng() {
		return qiyemingcheng;
	}
	/**
	 * 设置：企业地址
	 */
	public void setQiyedizhi(String qiyedizhi) {
		this.qiyedizhi = qiyedizhi;
	}
	/**
	 * 获取：企业地址
	 */
	public String getQiyedizhi() {
		return qiyedizhi;
	}
	/**
	 * 设置：联系电话
	 */
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
	}

}
