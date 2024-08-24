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

import com.cl.entity.SuodaikechengEntity;
import com.cl.entity.view.SuodaikechengView;

import com.cl.service.SuodaikechengService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 所带课程
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@RestController
@RequestMapping("/suodaikecheng")
public class SuodaikechengController {
    @Autowired
    private SuodaikechengService suodaikechengService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SuodaikechengEntity suodaikecheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			suodaikecheng.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SuodaikechengEntity> ew = new EntityWrapper<SuodaikechengEntity>();

		PageUtils page = suodaikechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, suodaikecheng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SuodaikechengEntity suodaikecheng, 
		HttpServletRequest request){
        EntityWrapper<SuodaikechengEntity> ew = new EntityWrapper<SuodaikechengEntity>();

		PageUtils page = suodaikechengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, suodaikecheng), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SuodaikechengEntity suodaikecheng){
       	EntityWrapper<SuodaikechengEntity> ew = new EntityWrapper<SuodaikechengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( suodaikecheng, "suodaikecheng")); 
        return R.ok().put("data", suodaikechengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SuodaikechengEntity suodaikecheng){
        EntityWrapper< SuodaikechengEntity> ew = new EntityWrapper< SuodaikechengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( suodaikecheng, "suodaikecheng")); 
		SuodaikechengView suodaikechengView =  suodaikechengService.selectView(ew);
		return R.ok("查询所带课程成功").put("data", suodaikechengView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SuodaikechengEntity suodaikecheng = suodaikechengService.selectById(id);
		suodaikecheng = suodaikechengService.selectView(new EntityWrapper<SuodaikechengEntity>().eq("id", id));
        return R.ok().put("data", suodaikecheng);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SuodaikechengEntity suodaikecheng = suodaikechengService.selectById(id);
		suodaikecheng = suodaikechengService.selectView(new EntityWrapper<SuodaikechengEntity>().eq("id", id));
        return R.ok().put("data", suodaikecheng);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SuodaikechengEntity suodaikecheng, HttpServletRequest request){
    	suodaikecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(suodaikecheng);
        suodaikechengService.insert(suodaikecheng);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SuodaikechengEntity suodaikecheng, HttpServletRequest request){
    	suodaikecheng.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(suodaikecheng);
        suodaikechengService.insert(suodaikecheng);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SuodaikechengEntity suodaikecheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(suodaikecheng);
        suodaikechengService.updateById(suodaikecheng);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        suodaikechengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
