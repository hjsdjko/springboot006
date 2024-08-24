package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GongzuoliangxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GongzuoliangxinxiView;


/**
 * 工作量信息
 *
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
public interface GongzuoliangxinxiService extends IService<GongzuoliangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GongzuoliangxinxiView> selectListView(Wrapper<GongzuoliangxinxiEntity> wrapper);
   	
   	GongzuoliangxinxiView selectView(@Param("ew") Wrapper<GongzuoliangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GongzuoliangxinxiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<GongzuoliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<GongzuoliangxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<GongzuoliangxinxiEntity> wrapper);



}

