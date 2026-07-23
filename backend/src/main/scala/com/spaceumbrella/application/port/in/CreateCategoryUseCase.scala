package com.spaceumbrella.application.port.in

import com.spaceumbrella.domain.model.category.Category
import com.spaceumbrella.application.command.CreateCategoryCmd
import scala.concurrent.Future

/**
 * Входящий порт (контракт) для сценария создания категории.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait CreateCategoryUseCase {
  def execute(cmd: CreateCategoryCmd): Future[Category]
}

