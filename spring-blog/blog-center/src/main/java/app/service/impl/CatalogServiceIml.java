package app.service.impl;

import app.dao.BaseDao;
import app.dao.CatalogDao;
import app.models.Catalog;
import app.service.CatalogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sdlili on 16-10-29.
 */
@Service
public class CatalogServiceIml extends BaseServiceImpl implements CatalogService {

    @Resource
    private CatalogDao catalogDao;

    public BaseDao getDao() {
        return catalogDao;
    }

}
