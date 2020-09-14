package model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "commetator_id")
    private long commentator_id;

    @Column(name = "comment_text")
    private String commentText;

    public Comment() {
    }

    public Comment(long id, long commentator_id, String commentText) {
        this.id = id;
        this.commentator_id = commentator_id;
        this.commentText = commentText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCommentator_id() {
        return commentator_id;
    }

    public void setCommentator_id(long commentator_id) {
        this.commentator_id = commentator_id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
