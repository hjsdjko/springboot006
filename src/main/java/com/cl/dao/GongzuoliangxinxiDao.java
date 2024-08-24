package com.cl.dao;

import com.cl.entity.GongzuoliangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuoliangxinxiView;


/**
 * 工作量信息
 * 
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface GongzuoliangxinxiDao extends BaseMapper<GongzuoliangxinxiEntity> {
	
	List<GongzuoliangxinxiView> selectListView(@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);

	List<GongzuoliangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);
	
	GongzuoliangxinxiView selectView(@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);



}
