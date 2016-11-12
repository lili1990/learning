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
import org.springframework.web.bind.annotation.*;

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
        article.setDescription(article.getContent().substring(0,200));
        articleService.saveOrUpdate(article);
        Long articleId= article.getId();
        articleCatalogService.deleteByArticle(articleId);
        articleCatalogService.save(new ArticleCatalog(articleId,articleAddModel.getCatalogId()));
        List<ArticleTag> articleTags = new ArrayList<ArticleTag>();
        for(Long tagId : articleAddModel.getTagIds()){
            articleTags.add(new ArticleTag(articleId,tagId));
        }
        articleTagService.deleteByArticle(articleId);
        articleTagService.batchSave(articleTags);
        return ResultVO.succeed(articleId);

    }

    @ResponseBody
    @RequestMapping(value="/{articleId}",method= RequestMethod.GET)
    public String  findById(@PathVariable("articleId")Long articleId){
        Article article=(Article)articleService.findById(articleId);
        return ResultVO.succeed(article);
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

    @ResponseBody
    @RequestMapping(value="/hot",method= RequestMethod.GET)
    public String  fetchHot(Page page){
        List<Article> articles = articleService.fetchHot(page);
        return ResultVO.succeed(articles);
    }

    @ResponseBody
    @RequestMapping(value="/latested",method= RequestMethod.GET)
    public String  fetchLatested(Page page){
        List<Article> articles = articleService.fetchLatest(page);
        return ResultVO.succeed(articles);
    }

    @ResponseBody
    @RequestMapping(value="/top",method= RequestMethod.GET)
    public String  fetchTop(Page page){
        List<Article> articles = articleService.fetchTop(page);
        return ResultVO.succeed(articles);
    }












}
