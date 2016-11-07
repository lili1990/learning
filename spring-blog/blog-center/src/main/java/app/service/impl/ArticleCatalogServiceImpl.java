package app.service.impl;

import app.dao.ArticleCatalogDao;
import app.dao.ArticleTagDao;
import app.dao.BaseDao;
import app.models.Article;
import app.models.ArticleCatalog;
import app.service.ArticleCatalogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sdlili on 16-11-8.
 */
@Service
public class ArticleCatalogServiceImpl extends BaseServiceImpl implements ArticleCatalogService {


    @Resource
    private ArticleCatalogDao articleCatalogDao;

    public BaseDao getDao() {
        return articleCatalogDao;
    }

    public void deleteByCatalog(Long catalog_id) {
        articleCatalogDao.deleteByCatalog(catalog_id);
    }

    public void deleteByArticle(Long article_id) {
        articleCatalogDao.deleteByArticle(article_id);
    }

    public List<Article> fetchArticlesByCatalogId(Long catalogId){

        return articleCatalogDao.fetchArticlesByCatalogId(catalogId);
    }
}
