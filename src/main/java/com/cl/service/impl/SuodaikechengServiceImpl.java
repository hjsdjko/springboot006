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


import com.cl.dao.SuodaikechengDao;
import com.cl.entity.SuodaikechengEntity;
import com.cl.service.SuodaikechengService;
import com.cl.entity.view.SuodaikechengView;

@Service("suodaikechengService")
public class SuodaikechengServiceImpl extends ServiceImpl<SuodaikechengDao, SuodaikechengEntity> implements SuodaikechengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SuodaikechengEntity> page = this.selectPage(
                new Query<SuodaikechengEntity>(params).getPage(),
                new EntityWrapper<SuodaikechengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SuodaikechengEntity> wrapper) {
		  Page<SuodaikechengView> page =new Query<SuodaikechengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<SuodaikechengView> selectListView(Wrapper<SuodaikechengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SuodaikechengView selectView(Wrapper<SuodaikechengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
