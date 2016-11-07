package app.service.impl;

import app.dao.ArticleTagDao;
import app.dao.BaseDao;
import app.service.ArticleTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sdlili on 16-10-29.
 */
@Service
public class ArticleTagServiceImpl extends BaseServiceImpl implements ArticleTagService {

    @Resource
    private ArticleTagDao articleTagDao;

    public BaseDao getDao() {
        return articleTagDao;
    }


    public void deleteByTag(Long tag_id) {
        articleTagDao.deleteByTag(tag_id);
    }

    public void deleteByArticle(Long article_id) {
        articleTagDao.deleteByArticle(article_id);
    }


}
