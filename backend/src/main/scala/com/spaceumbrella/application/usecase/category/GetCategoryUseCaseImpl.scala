package com.spaceumbrella.application.usecase.category

import com.spaceumbrella.application.port.in.GetCategoryUseCase
import com.spaceumbrella.application.port.out.CategoryRepository
import com.spaceumbrella.domain.model.category.{Category, CategoryId}
import scala.concurrent.Future

/**
 * Интерактор для сценария получения категории по ID.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
class GetCategoryUseCaseImpl(
  categoryRepository: CategoryRepository
) extends GetCategoryUseCase {

  override def execute(id: CategoryId): Future[Option[Category]] = {
    categoryRepository.findById(id)
  }
}

