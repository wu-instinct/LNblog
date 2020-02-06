package neusoft.service.impl;

import neusoft.mapper.BlogMapper;
import neusoft.mapper.BloggerMapper;
import neusoft.pojo.Blog;
import neusoft.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("blogService")
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;;
    @Override
    public List<Blog> countList() {
        return blogMapper.countList();
    }
    @Override
    public List<Blog> list(Map<String, Object> map) {
        return blogMapper.list(map);
    }
    @Override
    public Long getTotal(Map<String, Object> map) {
        return blogMapper.getTotal(map);
    }
    @Override
    public Blog getById(Integer id) {
        return blogMapper.getById(id);
    }
    @Override
    public Integer update(Blog blog) {
        return blogMapper.update(blog);
    }
    @Override
    public Blog getLastBlog(Integer id) {
        return blogMapper.getLastBlog(id);
    }
    @Override
    public Blog getNextBlog(Integer id) {
        return blogMapper.getNextBlog(id);
    }
    @Override
    public Integer add(Blog blog) {
        return blogMapper.add(blog);
    }
    @Override
    public Integer delete(Integer id) {
        return blogMapper.delete(id);
    }
    @Override
    public Integer getBlogByTypeId(Integer typeId) {
        return blogMapper.getBlogByTypeId(typeId);
    }



}
