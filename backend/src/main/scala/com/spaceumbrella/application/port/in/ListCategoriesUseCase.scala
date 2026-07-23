package com.spaceumbrella.application.port.in

import com.spaceumbrella.domain.model.category.Category
import scala.concurrent.Future

/**
 * Входящий порт (контракт) для сценария получения списка всех категорий.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait ListCategoriesUseCase {
  def execute(): Future[List[Category]]
}

