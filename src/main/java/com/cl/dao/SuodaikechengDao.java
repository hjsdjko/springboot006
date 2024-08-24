package com.cl.dao;

import com.cl.entity.SuodaikechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SuodaikechengView;


/**
 * 所带课程
 * 
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface SuodaikechengDao extends BaseMapper<SuodaikechengEntity> {
	
	List<SuodaikechengView> selectListView(@Param("ew") Wrapper<SuodaikechengEntity> wrapper);

	List<SuodaikechengView> selectListView(Pagination page,@Param("ew") Wrapper<SuodaikechengEntity> wrapper);
	
	SuodaikechengView selectView(@Param("ew") Wrapper<SuodaikechengEntity> wrapper);
	

}
