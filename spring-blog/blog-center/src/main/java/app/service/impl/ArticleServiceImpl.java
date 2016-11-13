package app.service.impl;

import app.dao.ArticleDao;
import app.dao.BaseDao;
import app.models.Article;
import app.mybatis.Page;
import app.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
@Service
public class ArticleServiceImpl extends BaseServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    public BaseDao getDao() {
        return articleDao;
    }

    public void addClick(Long id){
        articleDao.addClick(id);
    }

    public void addComment(Long id){
        articleDao.addComment(id);
    }

    public void addPraise(Long id){
        articleDao.addPraise(id);
    }

    public void top(Long id,boolean istop){
        articleDao.top(id,istop);
    }

    public void publish(Long id){
        articleDao.publish(id);
    }

    public void logicDelete(Long id){
        articleDao.logicDelete(id);
    }

    public List<Article> fetchTop(Page page){
       return  articleDao.fetchTop(page);
    }

    public List<Article> fetchLatest(Page page){
        return  articleDao.fetchLatest(page);
    }

    public List<Article> fetchHot(Page page){
        return  articleDao.fetchHot(page);
    }

    public List<Article> fetchByStatus(int status,Page page){
        return articleDao.fetchByStatus(status,page);
    }

    public List<Article> fetchBefore(Long articleId){
        return articleDao.fetchBefore(articleId);
    }

    public List<Article> fetchAfter(Long articleId){return articleDao.fetchAfter(articleId);}

}
