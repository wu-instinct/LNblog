package neusoft.service.impl;

        import neusoft.mapper.BloggerMapper;
        import neusoft.pojo.Blogger;
        import neusoft.service.BloggerService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
    @Autowired
    private BloggerMapper bloggerMapper;

    @Override
    public Blogger getById(Integer id) {
        return bloggerMapper.getById(id);
    }

    @Override
    public Blogger login(String name, String password) {
        return bloggerMapper.login(name, password);
    }

    @Override
    public Blogger getByName(String name) {
        return bloggerMapper.getByName(name);
    }

    @Override
    public boolean insert(Blogger bean) {
        return bloggerMapper.insert(bean);
    }

    @Override
    public boolean update(Blogger bean) {
        return bloggerMapper.update(bean);
    }

    @Override
    public List<Blogger> getList() {
        return bloggerMapper.getList();
    }
}
