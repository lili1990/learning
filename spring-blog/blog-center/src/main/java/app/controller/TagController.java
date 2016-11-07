package app.controller;

import app.dao.ArticleTagDao;
import app.dao.TagDao;
import app.models.Tag;
import app.mybatis.Page;
import app.service.ArticleTagService;
import app.service.TagService;
import app.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lili19289 on 2016/11/7.
 */
@Controller
@RequestMapping("/article")
public class TagController {

    @Resource
    private TagService tagService;

    @Resource
    private ArticleTagService articleTagService;


    @RequestMapping("/add")
    public Long  addTag(Tag tag){
       return tagService.save(tag);
    }

    @RequestMapping("/delete")
    public void  deleteTag(Long tagId){
         tagService.delete(tagId);
    }

    @RequestMapping("/article")
    public String  fetchTagsByArticle(Long articleId){
        List<Tag> tags = tagService.fetch();
        return ResultVO.succeed(tags);
    }

    @ResponseBody
    @RequestMapping("/list")
    public String  addTag(Page page){
        List<Tag> tags = tagService.fetch(page);
        return ResultVO.succeed(tags);
    }


}
