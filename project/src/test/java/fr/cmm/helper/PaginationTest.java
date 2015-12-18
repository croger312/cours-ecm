package fr.cmm.helper;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PaginationTest {

    @Test
    public void getPageCountWithPageSizeMultiple() {
        Pagination pagination = new Pagination();
        pagination.setCount(100);
        pagination.setPageSize(20);

        assertEquals(5, pagination.getPageCount());
    }


    @Test
    public void getPageCountWithPageSizeNotMultiple() {
        Pagination pagination = new Pagination();
        pagination.setCount(50);
        pagination.setPageSize(20);

        assertEquals(3, pagination.getPageCount());
    }

    @Test
    public void getPageCountLimitsCondition() {
        Pagination pagination = new Pagination();
        pagination.setCount(0);
        pagination.setPageSize(20);

        assertEquals(0, pagination.getPageCount());
    }

    @Test
    public void getPagesTestMoinsDe10() {
        Pagination pagination = new Pagination();
        pagination.setCount(50);
        pagination.setPageSize(10);
        pagination.setPageIndex(5);
        assertEquals( asList(1,2,3,4,5), pagination.getPages());
    }

    @Test
    public void getPagesTestPlusDe10() {
        Pagination pagination = new Pagination();
        pagination.setCount(200);
        pagination.setPageSize(10);
        pagination.setPageIndex(7);
        assertEquals( asList(3,4,5,6,7,8,9,10,11,12), pagination.getPages());
    }


}
