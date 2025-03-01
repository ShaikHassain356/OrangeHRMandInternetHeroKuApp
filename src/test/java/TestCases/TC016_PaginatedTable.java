package TestCases;

import PageObjectClasses.PaginatedWebtable;
import TestBase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC016_PaginatedTable extends BaseTest {

    @Test
    public void handling() throws InterruptedException {
        try {
            PaginatedWebtable pt=new PaginatedWebtable(driver);
            pt.fetchdatafromtable();

        }
        catch (Exception e)
        {
            System.out.println("Test failed due to error: "+e.getMessage());
            e.printStackTrace();
            Assert.fail();
        }
    }
}
