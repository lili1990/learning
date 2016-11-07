package app.controller;

import app.dao.ArticleTagDao;
import app.dao.TagDao;
import app.models.Tag;
import app.mybatis.Page;
import app.service.ArticleTagService;
import app.service.TagService;
import app.vo.ResultVO;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lili19289 on 2016/11/7.
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    @Resource
    private ArticleTagService articleTagService;


    @RequestMapping(value="/add",method= RequestMethod.POST)
    public Long  addTag(@ApiParam @RequestBody Tag tag){
       return tagService.save(tag);
    }

    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public void  deleteTag(Long tagId){
         tagService.delete(tagId);
    }

    @RequestMapping(value="/article/{articleId}",method= RequestMethod.GET)
    public String  fetchTagsByArticle(Long articleId){
        List<Tag> tags = articleTagService.fetchByArticleId(articleId);
        return ResultVO.succeed(tags);
    }

    @ResponseBody
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String  addTag(Page page){
        List<Tag> tags = tagService.fetch(page);
        return ResultVO.succeed(tags);
    }


}
