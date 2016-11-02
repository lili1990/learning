package app.service;

/**
 * Created by sdlili on 16-10-29.
 */
public interface ArticleService extends BaseService{

    public void addClick(Long id);

    public void addComment(Long id);

    public void addPraise(Long id);

    public void top(Long id,boolean istop);

    public void publish(Long id);

    public void logicDelete(Long id);


}
