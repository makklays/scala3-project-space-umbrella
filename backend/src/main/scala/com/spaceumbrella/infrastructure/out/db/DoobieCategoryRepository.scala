package com.spaceumbrella.infrastructure.out.db

import doobie._
import doobie.implicits._
import cats.effect.IO
import cats.effect.unsafe.Implicits.global // Необходим для работы .unsafeToFuture()
import com.spaceumbrella.application.port.out.CategoryRepository
import com.spaceumbrella.domain.category.{Category, CategoryId}
import scala.concurrent.Future

/**
 * Реализация CategoryRepository с использованием Doobie.
 * @param xa Транзакционный транслятор Doobie.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
class DoobieCategoryRepository(xa: Transactor[IO])
  extends CategoryRepository with DoobieMapping {

  // Вспомогательный приватный метод для скрытия деталей трансляции IO во Future
  private def run[A](cio: ConnectionIO[A]): Future[A] = {
    cio.transact(xa).unsafeToFuture()
  }

  override def create(category: Category): Future[Category] = {
    val query: ConnectionIO[Category] = sql"""
      INSERT INTO categories (title, description)
      VALUES (${category.title}, ${category.description})
      RETURNING id, title, description, created_at
    """.query[Category].unique

    run(query)
  }

  override def findById(id: CategoryId): Future[Option[Category]] = {
    val query: ConnectionIO[Option[Category]] = sql"""
      SELECT id, title, description, created_at
      FROM categories
      WHERE id = $id
    """.query[Category].option

    run(query)
  }

  override def findAll: Future[List[Category]] = {
    val query: ConnectionIO[List[Category]] = sql"""
      SELECT id, title, description, created_at
      FROM categories
    """.query[Category].to[List]

    run(query)
  }
}

