package neusoft.service;

import neusoft.pojo.BlogType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface BlogTypeService {

    /**
     * 查询所有博客类型 以及对应的博客数量
     * @return
     */
    public List<BlogType> countList();

    /**
     * 分页查询博客类别信息
     * @param map
     * @return
     */
    public List<BlogType> list(Map<String,Object> map);

    /**
     * 获取总记录数
     * @param map
     * @return
     */
    public Long getTotal(Map<String,Object> map);

    /**
     * 添加博客类别信息
     * @param blogType
     * @return
     */
    public Integer add(BlogType blogType);

    /**
     * 修改博客类别信息
     * @param blogType
     * @return
     */
    public Integer update(BlogType blogType);

    /**
     * 删除博客类别信息
     * @param id
     * @return
     */
    public Integer delete(Integer id);
    /**
     * 查询指定的博客类别下的博客数量
     * @param typeId
     * @return
     */
    public Integer getBlogByTypeId(Integer typeId);

    public BlogType getById(Integer id);
}
