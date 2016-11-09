package app.models.requestVO;

import app.mybatis.Page;

/**
 * Created by lili19289 on 2016/11/9.
 */
public class ArticleQueryModel {

    public int status;

    public Page page;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
