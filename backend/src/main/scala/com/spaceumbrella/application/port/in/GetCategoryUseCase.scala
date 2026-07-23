package com.spaceumbrella.application.port.in

import com.spaceumbrella.domain.model.category.{Category, CategoryId}
import scala.concurrent.Future

/**
 * Входящий порт (контракт) для сценария получения категории по ID.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait GetCategoryUseCase {
  def execute(id: CategoryId): Future[Option[Category]]
}

