/**
 * 
 */
package org.acme.Resource;

import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.acme.Entity.Tag;
import org.acme.Repository.TagRepository;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 * @author Fikri
 *
 */

@Path("/tag")
public class TagResource {
	
	private final TagRepository tagRepository;

    public TagResource(TagRepository tTagRepository) {
        this.tagRepository = tTagRepository;
    }
    
    @GET
    public Iterable<Tag> findAll() {
        return tagRepository.findAll();
    }
    
    @GET
    @Path("{id}")
    public Tag findById(@PathParam long id) {
        Optional<Tag> opt = tagRepository.findById(id);
        return opt.get();
    }
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam long id) {
    	tagRepository.deleteById(id);
    }

    @POST
    public Tag create(Tag tag) {
        return tagRepository.save(tag);
    }

    @PUT
    public Tag update(Tag tag) {
        Optional<Tag> optional = tagRepository.findById(tag.getId());
        if (optional.isPresent()) {
        	Tag data = optional.get();
            data.setLabel(tag.getLabel());
            data.setPosts(tag.getPosts());
            return tagRepository.save(data);
        }

        throw new IllegalArgumentException("No Tag Data with id " + tag.getId() + " exists");
    }

}
