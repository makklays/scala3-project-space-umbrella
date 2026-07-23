package com.spaceumbrella.application.port.out

import com.spaceumbrella.domain.category.{Category, CategoryId}
import scala.concurrent.Future

/**
 * The CategoryRepository trait defines the contract for interacting with the data source to perform CRUD operations on Category entities.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait CategoryRepository {
  def create(category: Category): Future[Category]

  // Используем строго типизированный CategoryId вместо Long
  def findById(id: CategoryId): Future[Option[Category]]

  def findAll: Future[List[Category]]
}

