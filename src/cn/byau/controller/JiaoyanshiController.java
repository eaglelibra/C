package cn.byau.controller;


import cn.byau.entity.JysKind;
import cn.byau.entity.Jiaoyanshi;
import cn.byau.service.JysKindService;
import cn.byau.service.JiaoyanshiService;
import cn.byau.util.Result;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


/**
 * Created by tjh on 2017/5/13.
 */
@Controller("JiaoyanshiController")
@RequestMapping("/admin/jiaoyanshi")
public class JiaoyanshiController {

	@Autowired
	private JiaoyanshiService courseService;
	@Autowired
	private JysKindService courseKindService;
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	/**
	 * 跳转到添加页面
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/toSave")
	public String savePage(HttpServletRequest request) {

		List<JysKind> list = courseKindService.list();
		request.setAttribute("list", list);
		return "/admin/jiaoyanshi/save.jsp";
	}



	/**
	 * 跳转到分页显示页面
	 *
	 * @param pageNum  为当前页号
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/listByPage")
	public String listByPage(@RequestParam(defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(defaultValue = "5", required = false) Integer pageSize,
			@RequestParam(defaultValue = "", required = false) String jysmc, HttpServletRequest request,
			HttpServletResponse response) {
		PageInfo<Jiaoyanshi> pageInfo = courseService.listByPage(pageNum, pageSize, jysmc);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("name", jysmc);
		return "/admin/jiaoyanshi/list.jsp";

	}

	/**
	 * 跳转到添加页面
	 *
	 * @param
	 * @return
	 */

	@RequestMapping("/save")
	@ResponseBody
	public Result save(Jiaoyanshi course) {
		 logger.info("save方法入参{}"+course);
		Result result = new Result();
		try {
			courseService.save(course);
			result.setMsg("OK");
		} catch (Exception e) {
			result.setMsg("FAIL");
		}
		return result;

	}

	/**
	 * 跳转到更新页面
	 *
	 * @param request
	 * @return
	 */

	@RequestMapping("/toUpdate")
	public ModelAndView updatePage(HttpServletRequest request) {
		String courseId = request.getParameter("courseId");
		Jiaoyanshi course = courseService.getById(courseId);

		ModelAndView mv = new ModelAndView("/admin/jiaoyanshi/update.jsp");
		mv.addObject("course", course);

		List<JysKind> list = courseKindService.list();
		mv.addObject("list", list);

		return mv;
	}


	@RequestMapping("/update")
	@ResponseBody
	public Result update(Jiaoyanshi course) {
		logger.info("update方法入参{}"+course);
		Result result = new Result();
		try {
			courseService.update(course);
			result.setMsg("OK");
		} catch (Exception e) {
			result.setMsg("FAIL");
		}
		return result;
	}

	@RequestMapping("/deleteBatch")
	@ResponseBody
	public Result deleteBatch(String courseIds) {
		logger.info("deleteBatch方法入参{}"+courseIds);
		Result result = new Result();
		String ids[] = courseIds.split(",");
		List<String> idList = Arrays.asList(ids);
		courseService.deleteBatch(idList);
		result.setMsg("OK");
		return result;
	}


}
