package c.bmartinez.flickrfindr.data.dto;

class PhotosSearchResponse {
    private PhotosMetaData photos;
    private String stat;

    public void setPhotosMetaData(PhotosMetaData photos){
        this.photos = photos;
    }

    public PhotosMetaData getPhotosMetaData() {
        return photos;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getStat() {
        return stat;
    }
}
