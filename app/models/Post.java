package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

@Entity
public class Post extends Model {

    public String title;
    public Date postedAt;

    @Lob
    public String content;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;

<<<<<<< HEAD
    
=======
>>>>>>> 8b96aee1ae0520e6c9164f9272dae99e2bd91867
    public Post(User author, String title, String content) {
    	this.comments = new ArrayList<Comment>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        this.save();
        return this;
    }

<<<<<<< HEAD
    public Post previous() {
=======
	public Post previous() {
>>>>>>> 8b96aee1ae0520e6c9164f9272dae99e2bd91867
        return Post.find("postedAt < ? order by postedAt desc", postedAt).first();
    }

    public Post next() {
        return Post.find("postedAt > ? order by postedAt asc", postedAt).first();
    }

    public String toString() {
        return title;
    }

}
