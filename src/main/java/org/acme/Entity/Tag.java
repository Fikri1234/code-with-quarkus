/**
 * 
 */
package org.acme.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Fikri
 *
 */

@Entity
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    
	@ManyToMany(targetEntity = Post.class, cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH }, fetch = FetchType.LAZY, mappedBy = "tags")
	private Set<Post> posts = new HashSet<>();

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tag(Long id, String label, Set<Post> posts) {
		super();
		this.id = id;
		this.label = label;
		this.posts = posts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", label=" + label + ", posts=" + posts + "]";
	}

}
