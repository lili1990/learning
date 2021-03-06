package app.dao;

import app.models.Article;
import app.models.Tag;

import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleTagDao extends BaseDao{


    public void deleteByTag(Long tag_id);

    public void deleteByArticle(Long article_id);

    public List<Tag> fetchByArticleId(Long articleId);

    public List<Article> fetchByTagId(Long articleId);
}
