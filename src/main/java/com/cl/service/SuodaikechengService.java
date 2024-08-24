package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SuodaikechengEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SuodaikechengView;


/**
 * 所带课程
 *
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface SuodaikechengService extends IService<SuodaikechengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SuodaikechengView> selectListView(Wrapper<SuodaikechengEntity> wrapper);
   	
   	SuodaikechengView selectView(@Param("ew") Wrapper<SuodaikechengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SuodaikechengEntity> wrapper);
   	

}

