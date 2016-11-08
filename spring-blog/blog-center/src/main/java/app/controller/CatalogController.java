package app.controller;

import app.models.Article;
import app.models.Catalog;
import app.mybatis.Page;
import app.service.ArticleCatalogService;
import app.service.CatalogService;
import app.models.responseVO.ResultVO;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sdlili on 16-11-8.
 */
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Resource
    private CatalogService catalogService;

    @Resource
    private ArticleCatalogService articleCatalogService;

    @RequestMapping(value="/add",method= RequestMethod.POST)
    public Long  addTag(@ApiParam @RequestBody Catalog catalog){
        return catalogService.save(catalog);
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public void  deleteTag(Long catalogId){
        catalogService.delete(catalogId);
    }

    @RequestMapping(value="/articles",method= RequestMethod.GET)
    public String  fetchArticles(Long catalogId){
        List<Article> articles = articleCatalogService.fetchArticlesByCatalogId(catalogId);
        return ResultVO.succeed(articles);
    }

    @ResponseBody
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String addTag(Page page){
        List<Catalog> catalogs = catalogService.fetch(page);
        return ResultVO.succeed(catalogs);
    }

}
