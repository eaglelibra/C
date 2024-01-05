package cn.byau.controller;


import cn.byau.dao.UserDAO;
import cn.byau.entity.User;
import cn.byau.service.LogInfoService;
import cn.byau.service.UserService;
import cn.byau.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private LogInfoService logInfoService;

	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/login", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, String> ajaxLogin(@RequestParam String userName, @RequestParam String password,
										 HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
		Map<String, String> responseMap = new HashMap<>();

		// ����������ַ�����ΪUTF-8
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String, String> credentials = new HashMap<>();
		credentials.put("userName", userName);
		credentials.put("password", password);
		InetAddress localHost = InetAddress.getLocalHost();
		String ipAddress = localHost.getHostAddress();  //��ȡip��ַ
		User user = userService.getUserByUserNameAndPassword(credentials);
		User  selectNmae =userDAO.getUserName(userName);
		String status="";
		if (user != null) {
			status="��¼�ɹ�";
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user.getRoleId().equals(CommonUtils.ADMIN_ROLE)) {
				session.setAttribute("loginFlag", "adminLogin");
				responseMap.put("redirect", "/admin/index.jsp");
			} else if (user.getRoleId().equals(CommonUtils.USER_ROlE)) {
				session.setAttribute("loginFlag", "userLogin");
				responseMap.put("redirect", "/user/index.jsp");
			}
		} else {
			status="�û������������";
			responseMap.put("error", "�û������������");
		}
		if(selectNmae!=null){
			logInfoService.save(selectNmae.getUserId(),ipAddress,status);
		}else {
			responseMap.put("error", "�û���������!");
		}


		return responseMap;
	}

	/**
	 * �˳���¼
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// ���Session
		session.invalidate();
		// �ض��򵽵�¼ҳ�����ת����
		return "redirect:/login.jsp";
	}
	/**
	 * ���û���½ҳ����ת
	 */
	@RequestMapping(value = "/toLogin", method = RequestMethod.GET)
	public String loginPage() {
		return "redirect:/login.jsp";
	}
}
