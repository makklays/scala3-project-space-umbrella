package com.spaceumbrella.application.usecase.category

import com.spaceumbrella.domain.model.category.Category
import com.spaceumbrella.application.port.out.CategoryRepository
import scala.concurrent.Future

/**
 * Use case for retrieving all categories.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */

// Интерфейс входящего порта
trait ListCategoriesUseCase {
  def execute(): Future[List[Category]]
}

// Реализация входящего порта
class ListCategoriesUseCaseImpl(
  categoryRepository: CategoryRepository
) extends ListCategoriesUseCase {

  override def execute(): Future[List[Category]] = {
    categoryRepository.findAll
  }
}

