/**
 * 
 */
package org.acme.Repository;

import org.acme.Entity.Tag;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Fikri
 *
 */
public interface TagRepository extends CrudRepository<Tag, Long> {

}
