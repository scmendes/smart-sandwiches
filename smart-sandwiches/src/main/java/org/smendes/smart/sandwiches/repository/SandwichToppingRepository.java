package org.smendes.smart.sandwiches.repository;

import org.smendes.smart.sandwiches.entity.SandwichTopping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Manage Topping entities.
 * @author mendes
 *
 */
@RepositoryRestResource
public interface SandwichToppingRepository extends CrudRepository<SandwichTopping, Long> {
	
}