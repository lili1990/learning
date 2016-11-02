package app.models;

/**
 * Created by sdlili on 16-10-29.
 */
public class ArticleCatalog extends BaseModel{


    public long article_id;

    public long catalog_id;

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public long getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(long catalog_id) {
        this.catalog_id = catalog_id;
    }
}
