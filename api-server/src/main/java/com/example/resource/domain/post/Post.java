package com.example.resource.domain.post;

import com.example.resource.domain.comment.Comment;
import com.example.resource.domain.common.Modified;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = 0")
@Builder
public class Post extends Modified {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @OneToMany
    @JoinColumn(name = "post_id")
    private Collection<Comment> commentList;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "deleted")
    private boolean deleted;

    public void deleted() {
        this.deleted = true;
    }
}
