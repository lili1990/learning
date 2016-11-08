package app.dao;

import app.models.Article;
import app.mybatis.Page;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleDao extends BaseDao {


    public void addClick(Long id);

    public void addComment(Long id);

    public void addPraise(Long id);

    public void top(Long id,boolean istop);

    public void publish(Long id);

    public void logicDelete(Long id);

    public List<Article> fetchTop(Page page);//查询置顶文章

    public List<Article> fetchLatest(Page page);//最新文章

    public List<Article> fetchHot(Page page);//获取最新文章

    public List<Article> fetchByStatus(int status,Page page);

}
