package app.models;

/**
 * Created by sdlili on 16-10-29.
 */
public class ArticleTag extends BaseModel{

    public long article_id;

    public long tag_id;

    public ArticleTag(){

    }

    public ArticleTag(long article_id, long tag_id) {
        this.article_id = article_id;
        this.tag_id = tag_id;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public long getTag_id() {
        return tag_id;
    }

    public void setTag_id(long tag_id) {
        this.tag_id = tag_id;
    }
}
