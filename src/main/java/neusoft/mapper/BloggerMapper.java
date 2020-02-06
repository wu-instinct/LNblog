package neusoft.mapper;

import neusoft.pojo.Blogger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BloggerMapper {
    Blogger getById(Integer id);
    Blogger login(@Param("name") String name, @Param("password") String password);
    Blogger getByName(String name);
    boolean insert(Blogger bean);
    boolean update(Blogger bean);
    List<Blogger> getList();
}
