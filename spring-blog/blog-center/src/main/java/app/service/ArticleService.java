package app.service;

import app.models.Article;
import app.mybatis.Page;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleService extends BaseService{

    public void addClick(Long id);

    public void addComment(Long id);

    public void addPraise(Long id);

    public void top(Long id,boolean istop);

    public void publish(Long id);

    public void logicDelete(Long id);

    public List<Article> fetchTop(Page page);

    public List<Article> fetchLatest(Page page);

    public List<Article> fetchHot(Page page);

    public List<Article> fetchByStatus(int status,Page page);

    public List<Article> fetchBefore(Long articleId);

    public List<Article> fetchAfter(Long articleId);

}
