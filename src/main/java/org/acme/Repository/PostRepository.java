/**
 * 
 */
package org.acme.Repository;

import java.util.List;

import org.acme.Entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fikri
 *
 */
public interface PostRepository extends CrudRepository<Post, Long> {
	
	List<Post> findByTittleContainingIgnoreCase(String tittle);

}
