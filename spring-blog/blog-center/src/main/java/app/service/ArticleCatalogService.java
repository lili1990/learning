package app.service;

import app.models.Article;
import app.models.Catalog;
import app.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleCatalogService extends BaseService{

    public void deleteByCatalog(Long catalog_id);

    public void deleteByArticle(Long article_id);

    public List<Article> fetchArticlesByCatalogId(Long catalogId);

    public List<Article> fetchArticlesByCatalogName(String alias_name);

    public Catalog fetchByArticleId(Long articleId);
}
