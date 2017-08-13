package org.smendes.smart.sandwiches.repository;

import org.smendes.smart.sandwiches.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Manage Ingredient entities.
 * @author mendes
 *
 */
@RepositoryRestResource
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	/**
	 * Find by Ingredient name.
	 * @param name
	 * @return Ingredient
	 */
	Ingredient findByName(String name);
	
}