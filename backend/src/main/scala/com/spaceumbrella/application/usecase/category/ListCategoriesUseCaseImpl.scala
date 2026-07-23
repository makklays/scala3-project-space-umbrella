package com.spaceumbrella.application.usecase.category

import com.spaceumbrella.application.port.in.ListCategoriesUseCase
import com.spaceumbrella.application.port.out.CategoryRepository
import com.spaceumbrella.domain.model.category.Category
import scala.concurrent.Future

/**
 * Интерактор для сценария получения списка всех категорий.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
class ListCategoriesUseCaseImpl(
  categoryRepository: CategoryRepository
) extends ListCategoriesUseCase {

  override def execute(): Future[List[Category]] = {
    categoryRepository.findAll
  }
}

