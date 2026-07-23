package com.spaceumbrella.application.usecase.category

// Исправленные импорты: модель из домена, репозиторий из port.out, команда из port.in
import com.spaceumbrella.domain.model.category.Category
import com.spaceumbrella.application.port.out.CategoryRepository
import com.spaceumbrella.application.port.in.CreateCategoryCmd

import scala.concurrent.{ExecutionContext, Future}

/**
 * Сценарий создания категории.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */

// Интерфейс входящего порта сценария (Использует готовую команду вместо дублирующего Request)
trait CreateCategoryUseCase {
  def execute(cmd: CreateCategoryCmd): Future[Category]
}

// Реализация входящего порта (Application Service / Interactor)
class CreateCategoryUseCaseImpl(
  categoryRepository: CategoryRepository
)(implicit ec: ExecutionContext) extends CreateCategoryUseCase {

  override def execute(cmd: CreateCategoryCmd): Future[Category] = {
    // Делегируем создание доменной сущности фабричному методу в домене
    val newCategory = Category.create(
      title = cmd.title,
      description = cmd.description
    )

    // Вызываем исходящий порт (репозиторий из application.port.out)
    categoryRepository.create(newCategory)
  }
}

