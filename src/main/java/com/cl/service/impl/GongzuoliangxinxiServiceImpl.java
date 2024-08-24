package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.GongzuoliangxinxiDao;
import com.cl.entity.GongzuoliangxinxiEntity;
import com.cl.service.GongzuoliangxinxiService;
import com.cl.entity.view.GongzuoliangxinxiView;

@Service("gongzuoliangxinxiService")
public class GongzuoliangxinxiServiceImpl extends ServiceImpl<GongzuoliangxinxiDao, GongzuoliangxinxiEntity> implements GongzuoliangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuoliangxinxiEntity> page = this.selectPage(
                new Query<GongzuoliangxinxiEntity>(params).getPage(),
                new EntityWrapper<GongzuoliangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuoliangxinxiEntity> wrapper) {
		  Page<GongzuoliangxinxiView> page =new Query<GongzuoliangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongzuoliangxinxiView> selectListView(Wrapper<GongzuoliangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuoliangxinxiView selectView(Wrapper<GongzuoliangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<GongzuoliangxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<GongzuoliangxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<GongzuoliangxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
