package app.service;

import app.models.Catalog;

/**
 * Created by sdlili on 16-10-29.
 */
public interface CatalogService extends BaseService{


    public Catalog finByALiasName(String alias_name);
}
