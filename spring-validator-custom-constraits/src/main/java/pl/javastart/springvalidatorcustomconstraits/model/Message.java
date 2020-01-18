package pl.javastart.springvalidatorcustomconstraits.model;

import pl.javastart.springvalidatorcustomconstraits.common.Lang;
import pl.javastart.springvalidatorcustomconstraits.constraint.NotBadWord;

import javax.validation.constraints.NotNull;

public class Message {

    @NotNull
    private String title;

    @NotBadWord(lang = Lang.EN)
    private String content;

    public Message() {
    }

    public Message(@NotNull String title, String content) {
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
