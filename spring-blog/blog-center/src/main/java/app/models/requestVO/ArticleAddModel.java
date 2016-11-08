package app.models.requestVO;

import app.models.Article;

import java.util.List;

/**
 * Created by sdlili on 16-11-8.
 */
public class ArticleAddModel {


    public Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public long catalogId;

    public List<Long> tagIds;

    public long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(long catalogId) {
        this.catalogId = catalogId;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
