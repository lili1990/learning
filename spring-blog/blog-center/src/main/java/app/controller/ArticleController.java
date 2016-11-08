package app.controller;

import app.dao.ArticleCatalogDao;
import app.dao.ArticleDao;
import app.dao.ArticleTagDao;
import app.models.Article;
import app.models.Catalog;
import app.mybatis.Page;
import app.service.ArticleCatalogService;
import app.service.ArticleService;
import app.service.ArticleTagService;
import app.vo.ResultVO;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sdlili on 16-10-29.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {


    @Resource
    private ArticleService articleService;

    @Resource
    private ArticleTagService articleTagService;

    @Resource
    private ArticleCatalogService articleCatalogService;


    @RequestMapping(value="/add",method= RequestMethod.POST)
    public Long  addArticle(@ApiParam  Article article){
        article.description=article.content.substring(0,100);
        return articleService.save(article);
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public void  deleteArticle(Long articleId){
        articleService.delete(articleId);
    }

    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public void  editArticle(@ApiParam @RequestBody Article article){
         articleService.update(article);
    }










}
