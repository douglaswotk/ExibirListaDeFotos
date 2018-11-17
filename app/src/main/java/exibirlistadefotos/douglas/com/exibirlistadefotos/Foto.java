package exibirlistadefotos.douglas.com.exibirlistadefotos;

import java.io.Serializable;
import java.util.Objects;

public class Foto implements Serializable {

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int albumId;
    public int id;
    public String title;
    public String url;
    public String thumbnailUrl;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foto foto = (Foto) o;
        return albumId == foto.albumId &&
                id == foto.id &&
                Objects.equals(title, foto.title) &&
                Objects.equals(url, foto.url) &&
                Objects.equals(thumbnailUrl, foto.thumbnailUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(albumId, id, title, url, thumbnailUrl);
    }
}
