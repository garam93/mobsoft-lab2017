package com.example.mobsoft.mobsoft.model;

import java.util.Date;
import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mobsoft on 2017. 04. 07..
 */

@ApiModel(description = "")
@Table
public class News{

    private Long id = null;

    @SerializedName("title")
    private String title = null;

    @SerializedName("url")
    private String url = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("publishedAt")
    private String publishedAt = null;

    @SerializedName("urlToImage")
    private String urlToImage = null;

    @SerializedName("author")
    private String author = null;



    /**
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getDescription() {
        return description;
    }
    public void setDescription(String body) {
        this.description = body;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getDate() {
        return publishedAt;
    }
    public void setDate(String date) {
        this.publishedAt = date;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getUrlToImage() {
        return urlToImage;
    }
    public void setUrlToImage(String coverImageUrl) {
        this.urlToImage = coverImageUrl;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


/*
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        News news = (News) o;
        return Objects.equals(id, news.id) &&
                Objects.equals(title, news.title) &&
                Objects.equals(url, news.url) &&
                Objects.equals(description, news.description) &&
                Objects.equals(publishedAt, news.publishedAt) &&
                Objects.equals(urlToImage, news.urlToImage) &&
                Objects.equals(author, news.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, url, description, publishedAt, urlToImage, author);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class News {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    lead: ").append(toIndentedString(url)).append("\n");
        sb.append("    body: ").append(toIndentedString(description)).append("\n");
        sb.append("    date: ").append(toIndentedString(publishedAt)).append("\n");
        sb.append("    coverImageUrl: ").append(toIndentedString(urlToImage)).append("\n");
        sb.append("    author: ").append(toIndentedString(author)).append("\n");
        sb.append("}");
        return sb.toString();
    }
*/
    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public News(){

    }

    public News(Long id, String title, String lead, String body, String date, String coverImageUrl, String author){
        this.id = id;
        this.title = title;
        this.url = lead;
        this.description = body;
        this.publishedAt = date;
        this.urlToImage = coverImageUrl;
        this.author = author;
    }
}
