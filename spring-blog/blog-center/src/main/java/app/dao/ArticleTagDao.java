package app.dao;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleTagDao extends BaseDao{


    public void deleteByTag(Long tag_id);

    public void deleteByArticle(Long article_id);
}
