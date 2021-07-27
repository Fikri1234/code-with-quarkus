/**
 * 
 */
package org.acme.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Fikri
 *
 */

@Entity
public class Post {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "tittle")
    private String tittle;
    
    @Lob
	@Column(name = "content", length=512)
    private String content;
    
    @ManyToMany(targetEntity = Tag.class, 
    		cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER )
    @JoinTable(
            name="post_tag",
            joinColumns=
            @JoinColumn( name="post_id"),
            inverseJoinColumns=@JoinColumn(name="tag_id"))
    @JsonBackReference
    private Set<Tag> tags = new HashSet<>();

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(Long id, String tittle, String content, Set<Tag> tags) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.content = content;
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", tittle=" + tittle + ", content=" + content + ", tags=" + tags + "]";
	}

}
