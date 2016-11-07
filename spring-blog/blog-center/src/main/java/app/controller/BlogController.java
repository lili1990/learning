package app.controller;

import app.dao.ArticleCatalogDao;
import app.dao.ArticleDao;
import app.dao.ArticleTagDao;
import app.models.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by sdlili on 16-10-29.
 */
@Controller
@RequestMapping("/article")
public class BlogController {


    @Resource
    private ArticleDao articleDao;

    @Resource
    private ArticleTagDao articleTagDao;

    @Resource
    private ArticleCatalogDao articleCatalogDao;
}
