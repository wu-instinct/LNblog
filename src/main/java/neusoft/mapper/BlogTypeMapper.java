package neusoft.mapper;

import neusoft.pojo.BlogType;

import java.util.List;
import java.util.Map;

public interface BlogTypeMapper {

    public List<BlogType> countList();

    public List<BlogType> list(Map<String,Object> map);

    public Long getTotal(Map<String,Object> map);

    public Integer add(BlogType blogType);

    public Integer update(BlogType blogType);

    public Integer delete(Integer id);

    public Integer getBlogByTypeId(Integer typeId);

    public BlogType getById(Integer id);
}
