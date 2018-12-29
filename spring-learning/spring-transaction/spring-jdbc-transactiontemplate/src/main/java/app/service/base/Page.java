package app.service.base;

/**
 * Created by lili19289 on 2016/12/27.
 */
public class Page {

    public int page;

    public int pageSize;

    public int start_index;

    public int end_index;

    public Page(){

    }

    public Page(int page,int pageSize){
        this.page=page;
        this.pageSize=pageSize;
        if(page >=1) {
            this.start_index = (page - 1) * pageSize;
            this.end_index = page * pageSize;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart_index() {
        return start_index;
    }

    public void setStart_index(int start_index) {
        this.start_index = start_index;
    }

    public int getEnd_index() {
        return end_index;
    }

    public void setEnd_index(int end_index) {
        this.end_index = end_index;
    }
}
