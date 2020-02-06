package neusoft.service;

import neusoft.pojo.Blogger;

import java.util.List;

public interface BloggerService {
    Blogger getById(Integer id);
    Blogger login(String name, String password);
    Blogger getByName(String name);
    boolean insert(Blogger bean);
    boolean update(Blogger bean);
    List<Blogger> getList();
}
