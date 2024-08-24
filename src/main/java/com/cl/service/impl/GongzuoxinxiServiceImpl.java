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


import com.cl.dao.GongzuoxinxiDao;
import com.cl.entity.GongzuoxinxiEntity;
import com.cl.service.GongzuoxinxiService;
import com.cl.entity.view.GongzuoxinxiView;

@Service("gongzuoxinxiService")
public class GongzuoxinxiServiceImpl extends ServiceImpl<GongzuoxinxiDao, GongzuoxinxiEntity> implements GongzuoxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GongzuoxinxiEntity> page = this.selectPage(
                new Query<GongzuoxinxiEntity>(params).getPage(),
                new EntityWrapper<GongzuoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GongzuoxinxiEntity> wrapper) {
		  Page<GongzuoxinxiView> page =new Query<GongzuoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GongzuoxinxiView> selectListView(Wrapper<GongzuoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GongzuoxinxiView selectView(Wrapper<GongzuoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
