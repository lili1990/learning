package app.service;

import app.models.Article;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleCatalogService {

    public void deleteByCatalog(Long catalog_id);

    public void deleteByArticle(Long article_id);

    public List<Article> fetchArticlesByCatalogId(Long catalogId);
}
