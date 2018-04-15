package com.example.blog.domain.post;

import com.example.blog.domain.common.Modified;
import com.example.blog.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted = 0")
public class Post extends Modified {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "page_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Where(clause = "deleted = 0")
    private User user;

    @Column
    private boolean deleted;

    public void deleted() {
        this.deleted = true;
    }
}
