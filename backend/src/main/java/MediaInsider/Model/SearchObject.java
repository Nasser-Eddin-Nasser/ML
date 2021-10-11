package MediaInsider.Model;

public class SearchObject {
    private Object searchKey1;
    private Object searchKey2;
    private Object searchKey3;

    public SearchObject() {
    }

    public SearchObject(Object searchKey1, Object searchKey2, Object searchKey3) {
        this.searchKey1 = searchKey1;
        this.searchKey2 = searchKey2;
        this.searchKey3 = searchKey3;
    }

    public Object getSearchKey1() {
        return searchKey1;
    }

    public Object getSearchKey2() {
        return searchKey2;
    }

    public Object getSearchKey3() {
        return searchKey3;
    }
}
