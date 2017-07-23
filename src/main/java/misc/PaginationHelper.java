package misc;
import java.util.List;

// misc.Solution for https://www.codewars.com/trainer/java

public class PaginationHelper<I> {

    List<I> data;
    int pageSize;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        data = collection;
        this.pageSize = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return data.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return data.size()/pageSize + ((data.size()%pageSize) == 0 ? 0 : 1);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex >= pageCount()) {
            return -1;
        }
        return pageIndex < pageCount() - 1 ? pageSize : (data.size()%pageSize);
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= data.size()) {
            return -1;
        }
        return itemIndex / pageSize;
    }
}