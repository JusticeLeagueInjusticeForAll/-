package tools;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = -3198048449643774660L;  
	  
    private int pageNow = 1; // 褰撳墠椤垫暟  
  
    private int pageSize = 4; // 姣忛〉鏄剧ず璁板綍鐨勬潯鏁� 
  
    private int totalCount; // 鎬荤殑璁板綍鏉℃暟  
  
    private int totalPageCount; // 鎬荤殑椤垫暟  
  
    @SuppressWarnings("unused")  
    private int startPos; // 寮�浣嶇疆锛屼粠0寮�  
  
    @SuppressWarnings("unused")  
    private boolean hasFirst;// 鏄惁鏈夐椤� 
  
    @SuppressWarnings("unused")  
    private boolean hasPre;// 鏄惁鏈夊墠涓�〉  
  
    @SuppressWarnings("unused")  
    private boolean hasNext;// 鏄惁鏈変笅涓�〉  
  
    @SuppressWarnings("unused")  
    private boolean hasLast;// 鏄惁鏈夋渶鍚庝竴椤� 
      
    /** 
     * 閫氳繃鏋勯�鍑芥暟 浼犲叆  鎬昏褰曟暟  鍜� 褰撳墠椤�
     * @param totalCount 
     * @param pageNow 
     */  
    public Page(int totalCount, int pageNow) {  
        this.totalCount = totalCount;  
        this.pageNow = pageNow;  
    }  
      
    /** 
     * 鍙栧緱鎬婚〉鏁帮紝鎬婚〉鏁�鎬昏褰曟暟/鎬婚〉鏁�
     * @return 
     */  
    public int getTotalPageCount() {  
        totalPageCount = getTotalCount() / getPageSize();  
        return (totalCount % pageSize == 0) ? totalPageCount  
                : totalPageCount + 1;  
    }  
  
    public void setTotalPageCount(int totalPageCount) {  
        this.totalPageCount = totalPageCount;  
    }  
  
    public int getPageNow() {  
        return pageNow;  
    }  
  
    public void setPageNow(int pageNow) {  
        this.pageNow = pageNow;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
  
    public int getTotalCount() {  
        return totalCount;  
    }  
  
    public void setTotalCount(int totalCount) {  
        this.totalCount = totalCount;  
    }  
    /** 
     * 鍙栧緱閫夋嫨璁板綍鐨勫垵濮嬩綅缃�
     * @return 
     */  
    public int getStartPos() {  
        return (pageNow - 1) * pageSize;  
    }  
  
    public void setStartPos(int startPos) {  
        this.startPos = startPos;  
    }  
  
    /** 
     * 鏄惁鏄涓�〉 
     * @return 
     */  
    public boolean isHasFirst() {  
        return (pageNow == 1) ? false : true;  
    }  
  
    public void setHasFirst(boolean hasFirst) {  
        this.hasFirst = hasFirst;  
    }  
    /** 
     * 鏄惁鏈夐椤�
     * @return 
     */  
    public boolean isHasPre() {  
        // 濡傛灉鏈夐椤靛氨鏈夊墠涓�〉锛屽洜涓烘湁棣栭〉灏变笉鏄涓�〉  
        return isHasFirst() ? true : false;  
    }  
  
    public void setHasPre(boolean hasPre) {  
        this.hasPre = hasPre;  
    }  
    /** 
     * 鏄惁鏈変笅涓�〉 
     * @return 
     */  
    public boolean isHasNext() {  
        // 濡傛灉鏈夊熬椤靛氨鏈変笅涓�〉锛屽洜涓烘湁灏鹃〉琛ㄦ槑涓嶆槸鏈�悗涓�〉  
        return isHasLast() ? true : false;  
    }  
  
    public void setHasNext(boolean hasNext) {  
        this.hasNext = hasNext;  
    }  
    /** 
     * 鏄惁鏈夊熬椤�
     * @return 
     */  
    public boolean isHasLast() {  
        // 濡傛灉涓嶆槸鏈�悗涓�〉灏辨湁灏鹃〉  
        return (pageNow == getTotalCount()) ? false : true;  
    }  
  
    public void setHasLast(boolean hasLast) {  
        this.hasLast = hasLast;  
    }  
}
