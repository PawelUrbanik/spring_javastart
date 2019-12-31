package pl.javastart.springmvcjstl.model;

import java.util.*;

public class Article {

    private String title;
    private String content;
    private List<String> tags;

    public Article() {
    }

    public Article(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        if (tags.length()>0 || tags!= null)
        {
            this.tags = Arrays.asList(tags.split(","));
        }
        else {
            this.tags = Collections.EMPTY_LIST;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(tags, article.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, tags);
    }
}
