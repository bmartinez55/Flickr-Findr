package c.bmartinez.flickrfindr.data.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosMetaData {
    private int page;
    private String pages;
    @SerializedName("perpage") private int perPage;
    private List<Photo> photo;
    private String total;

    public void setPage(int page) {
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return pages;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }
}
