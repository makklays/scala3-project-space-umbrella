package com.spaceumbrella.application.usecase.category

import com.spaceumbrella.domain.model.category.{Category, CategoryId}
import com.spaceumbrella.application.port.out.CategoryRepository
import scala.concurrent.Future

/**
 * Use case for retrieving a category by its ID.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait GetCategoryUseCase {
  // 2. Используем строго типизированный CategoryId вместо примитивного Long
  def execute(id: CategoryId): Future[Option[Category]]
}

class GetCategoryUseCaseImpl(
  categoryRepository: CategoryRepository
) extends GetCategoryUseCase {

  override def execute(id: CategoryId): Future[Option[Category]] = {
    categoryRepository.findById(id)
  }
}

