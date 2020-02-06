package neusoft.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neusoft.pojo.Blog;
import neusoft.pojo.BlogType;
import neusoft.pojo.Blogger;
import neusoft.pojo.Link;
import neusoft.service.BlogService;
import neusoft.service.BlogTypeService;
import neusoft.service.BloggerService;
import neusoft.service.LinkService;
import neusoft.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {

	@Resource
	private BloggerService bloggerService;
	
	@Resource
	private BlogTypeService blogTypeService;
	
	@Resource
	private BlogService blogService;
	
	@Resource
	private LinkService linkService;

	@RequestMapping("/refreshSystem")
	public String refreshSystem(HttpServletResponse response,HttpServletRequest request)throws Exception{
		System.out.println("id:::");
		ServletContext application=RequestContextUtils.findWebApplicationContext(request).getServletContext();
		Blogger blogger=bloggerService.getById(1);
		blogger.setPassword(null);
		application.setAttribute("blogger", blogger);
		
		List<BlogType> blogTypeCountList=blogTypeService.countList(); //查询博客类别以及博客的数量
		assert application != null;
		application.setAttribute("blogTypeCountList", blogTypeCountList);
		
		List<Blog> blogCountList=blogService.countList(); // 根据日期分组查询博客
		application.setAttribute("blogCountList", blogCountList);
		
		List<Link> linkList=linkService.list(null); // 获取所有友情链接
		application.setAttribute("linkList", linkList);
		
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
}
