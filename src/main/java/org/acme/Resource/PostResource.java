/**
 * 
 */
package org.acme.Resource;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.acme.DTO.PostDTO;
import org.acme.Entity.Post;
import org.acme.Entity.Tag;
import org.acme.Repository.PostRepository;
import org.acme.Repository.TagRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 * @author Fikri
 *
 */

@Path("/post")
public class PostResource {
	
	private final PostRepository postRepository;
	private final TagRepository tagRepository;

    public PostResource(PostRepository tPostRepository, TagRepository tagRepository) {
        this.postRepository = tPostRepository;
        this.tagRepository = tagRepository;
    }
    
    @GET
    public Iterable<PostDTO> findAll() {
        return StreamSupport.stream(postRepository.findAll().spliterator(), false).map(PostDTO::new).collect(Collectors.toList());
    }
	
    @GET
    @Path("/tittle/{tittle}")
    public List<Post> findByColor(@PathParam String tittle) {
        return postRepository.findByTittleContainingIgnoreCase(tittle);
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam long id) {
    	postRepository.deleteById(id);
    }

    @POST
    public Post create(PostDTO postDto) {
    	Post post = new Post();
    	post.setTittle(postDto.getTittle());
    	post.setContent(postDto.getContent());
    	if(postDto.getTags() != null) {
    		Set<Tag> tags = postDto.getTags().stream().map((x) -> tagRepository.findById(x).get()).collect(Collectors.toSet());
    		post.setTags(tags);
    	}
        return postRepository.save(post);
    }

    @PUT
    public Post update(PostDTO postDto) {
        Optional<Post> optional = postRepository.findById(postDto.getId());
        if (optional.isPresent()) {
            Post data = optional.get();
            data.setTittle(postDto.getTittle());
            data.setContent(postDto.getContent());
            if(postDto.getTags() != null) {
        		Set<Tag> tags = postDto.getTags().stream().map((x) -> tagRepository.findById(x).get()).collect(Collectors.toSet());
        		data.setTags(tags);
        	}
            return postRepository.save(data);
        }

        throw new IllegalArgumentException("No Post Data with id " + postDto.getId() + " exists");
    }
}
