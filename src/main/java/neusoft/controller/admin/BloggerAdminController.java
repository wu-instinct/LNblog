package neusoft.controller.admin;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neusoft.pojo.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import neusoft.service.BloggerService;
import neusoft.util.DateUtil;
import neusoft.util.ResponseUtil;

import net.sf.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

	@Resource
	private BloggerService bloggerService;


	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile, Blogger blogger, Model model,
					   BindingResult br, HttpServletRequest request, HttpServletResponse response)throws Exception{
		if(!imageFile.isEmpty()){
			String filePath=request.getServletContext().getRealPath("/");
			String imageName=DateUtil.getCurrentDateStr()+"."+imageFile.getOriginalFilename().split("\\.")[1];
			imageFile.transferTo(new File(filePath+"static/userImages/"+imageName));
			blogger.setImageName(imageName);
		}
		System.out.println(blogger);
		boolean resultTotal=bloggerService.update(blogger);
		System.out.println(resultTotal);
		StringBuffer result=new StringBuffer();
		if(resultTotal){
			result.append("<script language='javascript'>alert('修改成功');window.location.href='../modifyInfo.jsp'</script>");
		}else{
			result.append("<script language='javascript'>alert('修改失败');</script>");
		}
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/find")
	public String find(HttpServletResponse response, int id)throws Exception{
		Blogger blogger=bloggerService.getById(id);
		JSONObject jsonObject=JSONObject.fromObject(blogger);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	

	@RequestMapping("/modifyPassword")
	public String modifyPassword(String newPassword, int id, HttpServletResponse response)throws Exception{
		Blogger blogger=new Blogger();
		blogger.setPassword(newPassword);
		blogger.setId(id);
		System.out.println(blogger.getPassword());
		System.out.println(blogger.getId());
//		blogger.setPassword(CryptographyUtil.md5(newPassword, "programmer.ischoolbar.com"));
		boolean resultTotal=bloggerService.update(blogger);
		JSONObject result=new JSONObject();
		if(resultTotal){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/logout")
	public String  logout()throws Exception{
		//SecurityUtils.getSubject().logout();
		return "redirect:../../login.jsp";
	}
	@RequestMapping("/indexout")
	public String  indexout()throws Exception{
		//SecurityUtils.getSubject().logout();
		return "redirect:../index.html";
	}
}
