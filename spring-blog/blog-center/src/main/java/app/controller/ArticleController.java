package app.controller;

import app.models.Article;
import app.models.ArticleCatalog;
import app.models.ArticleTag;
import app.models.requestVO.ArticleAddModel;
import app.models.requestVO.ArticleQueryModel;
import app.models.responseVO.Result;
import app.models.responseVO.ResultVO;
import app.mybatis.Page;
import app.service.ArticleCatalogService;
import app.service.ArticleService;
import app.service.ArticleTagService;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

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


    @Transactional
    @ResponseBody
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public String  addArticle(@ApiParam @RequestBody ArticleAddModel articleAddModel){
        Article article = articleAddModel.getArticle();
        articleService.save(article);
        Long articleId= article.getId();
        articleCatalogService.save(new ArticleCatalog(articleId,articleAddModel.getCatalogId()));
        List<ArticleTag> articleTags = new ArrayList<ArticleTag>();
        for(Long tagId : articleAddModel.getTagIds()){
            articleTags.add(new ArticleTag());
        }
        articleTagService.batchSave(articleTags);
        return ResultVO.succeed(articleId);

    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public void  deleteArticle(Long articleId){
        articleService.delete(articleId);
    }

    @RequestMapping(value="/edit",method= RequestMethod.POST)
    public void  editArticle(@ApiParam @RequestBody Article article){
         articleService.update(article);
    }

    @ResponseBody
    @RequestMapping(value="/list",method= RequestMethod.POST)
    public String  fetchArticle(@ApiParam @RequestBody ArticleQueryModel articleQueryModel){
        List<Article> articles = articleService.fetchByStatus(articleQueryModel.getStatus(),articleQueryModel.getPage());
        return ResultVO.succeed(articles);
    }












}
