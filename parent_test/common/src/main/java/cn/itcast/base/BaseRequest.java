package cn.itcast.base;

public abstract class BaseRequest<T extends BaseResponse>{
    private int pageSize = 10;
    private int pageIndex = 1;
    private long pageCount;
    private int pageNum;
    private boolean hasNextPage;

    public abstract void check() throws Exception;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageInfo(long pageCount){
        pageCount = pageCount;
        pageNum = (int)(pageCount%pageSize == 0?pageCount/pageSize:(pageCount/pageSize+1));
        if(pageIndex<pageNum){
            hasNextPage = true;
        }else{
            hasNextPage = false;
        }
    }
}
