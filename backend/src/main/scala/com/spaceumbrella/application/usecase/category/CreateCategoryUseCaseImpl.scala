package com.spaceumbrella.application.usecase.category

import com.spaceumbrella.application.port.in.CreateCategoryUseCase
import com.spaceumbrella.application.command.CreateCategoryCmd
import com.spaceumbrella.application.port.out.CategoryRepository
import com.spaceumbrella.domain.model.category.Category
import scala.concurrent.{ExecutionContext, Future}

/**
 * Реализация входящего порта (Use Case) для создания категории.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
class CreateCategoryUseCaseImpl(
  categoryRepository: CategoryRepository
)(implicit ec: ExecutionContext) extends CreateCategoryUseCase {

  override def execute(cmd: CreateCategoryCmd): Future[Category] = {
    // Делегируем создание доменной сущности фабричному методу в домене
    val newCategory = Category.create(
      title = cmd.title,
      description = cmd.description
    )

    // Сохраняем через исходящий порт
    categoryRepository.create(newCategory)
  }
}

