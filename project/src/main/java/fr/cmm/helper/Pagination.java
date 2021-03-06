package fr.cmm.helper;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Pagination {
    // 1 based page index
    private int pageIndex;

    public static final int pagination_size = 10;

    private int pageSize;

    private long count;

    public int getPreviousPageIndex() {
        return isFirstPage() ? pageIndex : pageIndex - 1;
    }

    public int getNextPageIndex() {
        return isLastPage() ? pageIndex : pageIndex + 1;
    }

    public boolean isFirstPage() {
        return pageIndex == 1;
    }

    public boolean isLastPage() {
        return pageIndex * pageSize >= count;
    }

    public int getPageCount() {
        if ( count % pageSize != 0) {
            return (int) (count / pageSize)+1;
        } else {
            return (int) count / pageSize;
        }
    }

    public List<Integer> getPages() {
        List<Integer> l = new ArrayList<Integer>();
        getPageIndex();
        int compteur = 0;
        while( compteur<=5 ) {
            if (compteur == 0) {
                l.add(getPageIndex());
            }
            else {
                if (l.size() <pagination_size && getPageIndex()+compteur<=getPageCount()) {
                    l.add(getPageIndex() + compteur);
                }
                if (l.size() <pagination_size && getPageIndex()-compteur>0) {
                    l.add(0, getPageIndex() - compteur);
                }
            }
            compteur++;
        }
        return l;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
