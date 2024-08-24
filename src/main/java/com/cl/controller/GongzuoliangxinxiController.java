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

import com.cl.entity.GongzuoliangxinxiEntity;
import com.cl.entity.view.GongzuoliangxinxiView;

import com.cl.service.GongzuoliangxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 工作量信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-13 09:56:01
 */
@RestController
@RequestMapping("/gongzuoliangxinxi")
public class GongzuoliangxinxiController {
    @Autowired
    private GongzuoliangxinxiService gongzuoliangxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongzuoliangxinxiEntity gongzuoliangxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			gongzuoliangxinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();

		PageUtils page = gongzuoliangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoliangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongzuoliangxinxiEntity gongzuoliangxinxi, 
		HttpServletRequest request){
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();

		PageUtils page = gongzuoliangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongzuoliangxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongzuoliangxinxiEntity gongzuoliangxinxi){
       	EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongzuoliangxinxi, "gongzuoliangxinxi")); 
        return R.ok().put("data", gongzuoliangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongzuoliangxinxiEntity gongzuoliangxinxi){
        EntityWrapper< GongzuoliangxinxiEntity> ew = new EntityWrapper< GongzuoliangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongzuoliangxinxi, "gongzuoliangxinxi")); 
		GongzuoliangxinxiView gongzuoliangxinxiView =  gongzuoliangxinxiService.selectView(ew);
		return R.ok("查询工作量信息成功").put("data", gongzuoliangxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongzuoliangxinxiEntity gongzuoliangxinxi = gongzuoliangxinxiService.selectById(id);
		gongzuoliangxinxi = gongzuoliangxinxiService.selectView(new EntityWrapper<GongzuoliangxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzuoliangxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongzuoliangxinxiEntity gongzuoliangxinxi = gongzuoliangxinxiService.selectById(id);
		gongzuoliangxinxi = gongzuoliangxinxiService.selectView(new EntityWrapper<GongzuoliangxinxiEntity>().eq("id", id));
        return R.ok().put("data", gongzuoliangxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongzuoliangxinxiEntity gongzuoliangxinxi, HttpServletRequest request){
    	gongzuoliangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoliangxinxi);
        gongzuoliangxinxiService.insert(gongzuoliangxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongzuoliangxinxiEntity gongzuoliangxinxi, HttpServletRequest request){
    	gongzuoliangxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongzuoliangxinxi);
        gongzuoliangxinxiService.insert(gongzuoliangxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongzuoliangxinxiEntity gongzuoliangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongzuoliangxinxi);
        gongzuoliangxinxiService.updateById(gongzuoliangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongzuoliangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    GongzuoliangxinxiEntity gongzuoliangxinxiEntity =new GongzuoliangxinxiEntity();
                    gongzuoliangxinxiEntity.setId(new Date().getTime());
                    String lilun = CommonUtil.getCellValue(row.getCell(0));
                    gongzuoliangxinxiEntity.setLilun(lilun);
                    String shiyan = CommonUtil.getCellValue(row.getCell(1));
                    gongzuoliangxinxiEntity.setShiyan(shiyan);
                    String shixi = CommonUtil.getCellValue(row.getCell(2));
                    gongzuoliangxinxiEntity.setShixi(shixi);
                    String kechengxishu = CommonUtil.getCellValue(row.getCell(3));
                    gongzuoliangxinxiEntity.setKechengxishu(Double.parseDouble(kechengxishu));
                    String hebanshuliang = CommonUtil.getCellValue(row.getCell(4));
                    gongzuoliangxinxiEntity.setHebanshuliang(Integer.parseInt(hebanshuliang));
                    String jiaoshigonghao = CommonUtil.getCellValue(row.getCell(5));
                    gongzuoliangxinxiEntity.setJiaoshigonghao(jiaoshigonghao);
                    String jiaoshixingming = CommonUtil.getCellValue(row.getCell(6));
                    gongzuoliangxinxiEntity.setJiaoshixingming(jiaoshixingming);
                    String tijiaoshijian = CommonUtil.getCellValue(row.getCell(7));
                    try {
                        gongzuoliangxinxiEntity.setTijiaoshijian(new SimpleDateFormat("yyyy-MM-dd").parse(tijiaoshijian));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                     
                    //想数据库中添加新对象
                    gongzuoliangxinxiService.insert(gongzuoliangxinxiEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }

    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
		}
        List<Map<String, Object>> result = gongzuoliangxinxiService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul, HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongzuoliangxinxiService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = gongzuoliangxinxiService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) {
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = gongzuoliangxinxiService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<GongzuoliangxinxiEntity> ew = new EntityWrapper<GongzuoliangxinxiEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        List<Map<String, Object>> result = gongzuoliangxinxiService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }






}
