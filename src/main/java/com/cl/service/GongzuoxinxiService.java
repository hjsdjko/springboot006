package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongzuoxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuoxinxiView;


/**
 * 工作信息
 *
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface GongzuoxinxiService extends IService<GongzuoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuoxinxiView> selectListView(Wrapper<GongzuoxinxiEntity> wrapper);
   	
   	GongzuoxinxiView selectView(@Param("ew") Wrapper<GongzuoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuoxinxiEntity> wrapper);
   	

}

