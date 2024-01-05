package cn.byau.controller;


import cn.byau.entity.JysKind;
import cn.byau.service.JysKindService;
import cn.byau.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tjh on 2017/5/13.
 */
@Controller
@RequestMapping("/admin/jyskind")
public class JysKindController {

	@Autowired
	private JysKindService courseKindService;

	@RequestMapping("/list")
	public ModelAndView list(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("/admin/jyskind/list.jsp");
		mv.addObject("list", courseKindService.list());
		return mv;
	}


	@RequestMapping("/getDataGrid")
	// 浏览器直接测试 /getDataGrid?page=1&rows=2 这种形式
		public void datagrid(Integer page, Integer rows, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");   //请求跨域
        response.setContentType("text/json;charset=UTF-8");

		PageInfo<JysKind> pageInfo=courseKindService.listByPage(page, rows);
			long total=pageInfo.getTotal();
			ObjectMapper mapper = new ObjectMapper();
			// 返回JSON格式的响应
			try {
				String json = "{\"total\":"+total+",\"rows\":" + mapper.writeValueAsString(pageInfo.getList())  + "}";
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	@RequestMapping("/save")
	@ResponseBody
	public Result save(JysKind courseKind) {


		Result result = new Result();
		if(courseKindService.getByKindId(courseKind.getKindId())==null){
		try{
			courseKindService.save(courseKind);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL");
		}
		}else {
			 result.setMsg("主键重复");
		}
		return result;


	}

	@RequestMapping("/update")
	@ResponseBody
	public Result update(JysKind courseKind) {
		Result result = new Result();
		try{
			courseKindService.update(courseKind);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL");
		}
		return result;


	}


	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(String courseKindId) {
		Result result = new Result();
		try{
			courseKindService.delete(courseKindId);
     		result.setMsg("OK");
		}catch(Exception e){
	        result.setMsg("FAIL");
		}
		return result;
	}
}
