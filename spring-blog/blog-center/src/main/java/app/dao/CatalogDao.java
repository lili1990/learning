package app.dao;

import app.models.Catalog;

/**
 * Created by sdlili on 16-10-29.
 */
public interface CatalogDao extends BaseDao{

    public Catalog finByALiasName(String alias_name);
}
