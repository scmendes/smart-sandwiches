package org.smendes.smart.sandwiches.repository;

import org.smendes.smart.sandwiches.entity.Sandwich;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Manage Sandwich entities.
 * @author mendes
 *
 */
@RepositoryRestResource
public interface SandwichRepository extends CrudRepository<Sandwich, Long> {
	
	/**
	 * Find by Sandwich name.
	 * @param name
	 * @return Sandwich
	 */
	Sandwich findByName(String name);
	
}