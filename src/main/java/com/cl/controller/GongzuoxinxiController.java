package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.GongzuoxinxiEntity;
import com.cl.entity.view.GongzuoxinxiView;

import com.cl.service.GongzuoxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 工作信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@RestController
@RequestMapping("/gongzuoxinxi")
public class GongzuoxinxiController {
    @Autowired
    private GongzuoxinxiService gongzuoxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuoxinxiEntity gongzuoxinxi,
		HttpServletRequest request){
        EntityWrapper<GongzuoxinxiEntity> ew = new EntityWrapper<GongzuoxinxiEntity>();

		PageUtils page = gongzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuoxinxiEntity gongzuoxinxi, 
		HttpServletRequest request){
        EntityWrapper<GongzuoxinxiEntity> ew = new EntityWrapper<GongzuoxinxiEntity>();

		PageUtils page = gongzuoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuoxinxiEntity gongzuoxinxi){
       	EntityWrapper<GongzuoxinxiEntity> ew = new EntityWrapper<GongzuoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuoxinxi, "gongzuoxinxi")); 
        return R.ok().put("data", gongzuoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuoxinxiEntity gongzuoxinxi){
        EntityWrapper< GongzuoxinxiEntity> ew = new EntityWrapper< GongzuoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuoxinxi, "gongzuoxinxi")); 
		GongzuoxinxiView gongzuoxinxiView =  gongzuoxinxiService.selectView(ew);
		return R.ok("查询工作信息成功").put("data", gongzuoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuoxinxiEntity gongzuoxinxi = gongzuoxinxiService.selectById(id);
		gongzuoxinxi = gongzuoxinxiService.selectView(new EntityWrapper<GongzuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzuoxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuoxinxiEntity gongzuoxinxi = gongzuoxinxiService.selectById(id);
		gongzuoxinxi = gongzuoxinxiService.selectView(new EntityWrapper<GongzuoxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzuoxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuoxinxiEntity gongzuoxinxi, HttpServletRequest request){
    	gongzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoxinxi);
        gongzuoxinxiService.insert(gongzuoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuoxinxiEntity gongzuoxinxi, HttpServletRequest request){
    	gongzuoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoxinxi);
        gongzuoxinxiService.insert(gongzuoxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzuoxinxiEntity gongzuoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuoxinxi);
        gongzuoxinxiService.updateById(gongzuoxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
