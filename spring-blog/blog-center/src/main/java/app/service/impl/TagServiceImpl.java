package app.service.impl;

import app.dao.BaseDao;
import app.dao.TagDao;
import app.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sdlili on 16-10-29.
 */
@Service
public class TagServiceImpl extends BaseServiceImpl implements TagService {


    @Resource
    private TagDao tagDao;

    public BaseDao getDao() {
        return tagDao;
    }

}
