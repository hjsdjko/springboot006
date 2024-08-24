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
 * 工作量信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@TableName("gongzuoliangxinxi")
public class GongzuoliangxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public GongzuoliangxinxiEntity() {
		
	}
	
	public GongzuoliangxinxiEntity(T t) {
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
	 * 理论
	 */
					
	private String lilun;
	
	/**
	 * 实验
	 */
					
	private String shiyan;
	
	/**
	 * 实习
	 */
					
	private String shixi;
	
	/**
	 * 课程系数
	 */
					
	private Double kechengxishu;
	
	/**
	 * 合班数量
	 */
					
	private Integer hebanshuliang;
	
	/**
	 * 合班系数
	 */
					
	private Double hebanxishu;
	
	/**
	 * 指导毕业生人数
	 */
					
	private Double zhidaobiyeshengrenshu;
	
	/**
	 * 论文教学工作量
	 */
					
	private Double lunwenjiaoxuegongzuoliang;
	
	/**
	 * 实验类型系数
	 */
					
	private Double shiyanleixingxishu;
	
	/**
	 * 实验调整系数
	 */
					
	private Double shiyandiaozhengxishu;
	
	/**
	 * 当量学时
	 */
					
	private Double dangliangxueshi;
	
	/**
	 * 备注
	 */
					
	private String beizhu;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	/**
	 * 提交时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tijiaoshijian;
	
	
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
	 * 设置：理论
	 */
	public void setLilun(String lilun) {
		this.lilun = lilun;
	}
	/**
	 * 获取：理论
	 */
	public String getLilun() {
		return lilun;
	}
	/**
	 * 设置：实验
	 */
	public void setShiyan(String shiyan) {
		this.shiyan = shiyan;
	}
	/**
	 * 获取：实验
	 */
	public String getShiyan() {
		return shiyan;
	}
	/**
	 * 设置：实习
	 */
	public void setShixi(String shixi) {
		this.shixi = shixi;
	}
	/**
	 * 获取：实习
	 */
	public String getShixi() {
		return shixi;
	}
	/**
	 * 设置：课程系数
	 */
	public void setKechengxishu(Double kechengxishu) {
		this.kechengxishu = kechengxishu;
	}
	/**
	 * 获取：课程系数
	 */
	public Double getKechengxishu() {
		return kechengxishu;
	}
	/**
	 * 设置：合班数量
	 */
	public void setHebanshuliang(Integer hebanshuliang) {
		this.hebanshuliang = hebanshuliang;
	}
	/**
	 * 获取：合班数量
	 */
	public Integer getHebanshuliang() {
		return hebanshuliang;
	}
	/**
	 * 设置：合班系数
	 */
	public void setHebanxishu(Double hebanxishu) {
		this.hebanxishu = hebanxishu;
	}
	/**
	 * 获取：合班系数
	 */
	public Double getHebanxishu() {
		return hebanxishu;
	}
	/**
	 * 设置：指导毕业生人数
	 */
	public void setZhidaobiyeshengrenshu(Double zhidaobiyeshengrenshu) {
		this.zhidaobiyeshengrenshu = zhidaobiyeshengrenshu;
	}
	/**
	 * 获取：指导毕业生人数
	 */
	public Double getZhidaobiyeshengrenshu() {
		return zhidaobiyeshengrenshu;
	}
	/**
	 * 设置：论文教学工作量
	 */
	public void setLunwenjiaoxuegongzuoliang(Double lunwenjiaoxuegongzuoliang) {
		this.lunwenjiaoxuegongzuoliang = lunwenjiaoxuegongzuoliang;
	}
	/**
	 * 获取：论文教学工作量
	 */
	public Double getLunwenjiaoxuegongzuoliang() {
		return lunwenjiaoxuegongzuoliang;
	}
	/**
	 * 设置：实验类型系数
	 */
	public void setShiyanleixingxishu(Double shiyanleixingxishu) {
		this.shiyanleixingxishu = shiyanleixingxishu;
	}
	/**
	 * 获取：实验类型系数
	 */
	public Double getShiyanleixingxishu() {
		return shiyanleixingxishu;
	}
	/**
	 * 设置：实验调整系数
	 */
	public void setShiyandiaozhengxishu(Double shiyandiaozhengxishu) {
		this.shiyandiaozhengxishu = shiyandiaozhengxishu;
	}
	/**
	 * 获取：实验调整系数
	 */
	public Double getShiyandiaozhengxishu() {
		return shiyandiaozhengxishu;
	}
	/**
	 * 设置：当量学时
	 */
	public void setDangliangxueshi(Double dangliangxueshi) {
		this.dangliangxueshi = dangliangxueshi;
	}
	/**
	 * 获取：当量学时
	 */
	public Double getDangliangxueshi() {
		return dangliangxueshi;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
	/**
	 * 设置：提交时间
	 */
	public void setTijiaoshijian(Date tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	/**
	 * 获取：提交时间
	 */
	public Date getTijiaoshijian() {
		return tijiaoshijian;
	}

}
