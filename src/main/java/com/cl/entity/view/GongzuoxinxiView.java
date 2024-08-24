package com.cl.entity.view;

import com.cl.entity.GongzuoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 工作信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@TableName("gongzuoxinxi")
public class GongzuoxinxiView  extends GongzuoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GongzuoxinxiView(){
	}
 
 	public GongzuoxinxiView(GongzuoxinxiEntity gongzuoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, gongzuoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
