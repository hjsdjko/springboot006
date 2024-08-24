package com.cl.dao;

import com.cl.entity.GongzuoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuoxinxiView;


/**
 * 工作信息
 * 
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface GongzuoxinxiDao extends BaseMapper<GongzuoxinxiEntity> {
	
	List<GongzuoxinxiView> selectListView(@Param("ew") Wrapper<GongzuoxinxiEntity> wrapper);

	List<GongzuoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<GongzuoxinxiEntity> wrapper);
	
	GongzuoxinxiView selectView(@Param("ew") Wrapper<GongzuoxinxiEntity> wrapper);
	

}
