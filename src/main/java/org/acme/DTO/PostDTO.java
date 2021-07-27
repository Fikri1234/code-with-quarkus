/**
 * 
 */
package org.acme.DTO;

import java.util.Set;
import java.util.stream.Collectors;

import org.acme.Entity.Post;
import org.acme.Entity.Tag;

/**
 * @author Fikri
 *
 */
public class PostDTO {
	
	private Long id;
    private String tittle;
    private String content;
    private Set<Long> tags;
    
	public PostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.tittle = post.getTittle();
		this.content = post.getContent();
		this.tags = post.getTags().stream().map(Tag::getId).collect(Collectors.toSet());
//		this.tags = post.getTags().stream().collect(Collectors.toSet());
	}
	
	public PostDTO(Long id, String tittle, String content, Set<Long> tags) {
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
	public Set<Long> getTags() {
		return tags;
	}
	public void setTags(Set<Long> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "PostDTO [id=" + id + ", tittle=" + tittle + ", content=" + content + ", tags=" + tags + "]";
	}

}
