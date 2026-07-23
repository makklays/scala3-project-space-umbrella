package com.spaceumbrella.infrastructure.http

import org.http4s.*
import org.http4s.dsl.Http4sDsl
import io.circe.generic.auto.*
import org.http4s.circe.CirceEntityCodec.*

import com.spaceumbrella.domain.model.category.CategoryId
import com.spaceumbrella.application.port.in.CreateCategoryCmd
import com.spaceumbrella.application.usecase.category.{CreateCategoryUseCase, GetCategoryUseCase, ListCategoriesUseCase}
import scala.concurrent.{ExecutionContext, Future}
import cats.instances.future.* // Подключает поддержку Future в структуры Cats/Http4s

/**
 * HTTP маршруты для работы с категориями.
 *
 * @param createUseCase Use case для создания категории.
 * @param getUseCase Use case для получения категории по ID.
 * @param listUseCase Use case для листинга всех категорий.
 * @param ec ExecutionContext для асинхронных операций.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
class CategoryRoutes(
                      createUseCase: CreateCategoryUseCase,
                      getUseCase: GetCategoryUseCase,
                      listUseCase: ListCategoriesUseCase
                    )(implicit ec: ExecutionContext) {

  // Создаем DSL, привязанный исключительно к Future
  private val dsl = new Http4sDsl[Future] {}
  import dsl._

  // Тип маршрутов жестко завязан на Future, а не на IO
  val routes: HttpRoutes[Future] = HttpRoutes.of[Future] {

    // 1. Листинг
    case GET -> Root / "categories" =>
      listUseCase.execute().flatMap(categories => Ok(categories))

    // 2. Получение по ID
    case GET -> Root / "categories" / LongVar(id) =>
      // Оборачиваем примитивный Long в доменный Value Object CategoryId
      getUseCase.execute(CategoryId(id)).flatMap {
        case Some(category) => Ok(category)
        case None           => NotFound(s"Category $id not found")
      }

    // 3. Создание
    case req @ POST -> Root / "categories" =>
      // Используем валидную команду CreateCategoryCmd вместо удаленного Request
      req.as[CreateCategoryCmd].flatMap { cmd =>
        createUseCase.execute(cmd).flatMap(newCategory => Created(newCategory))
      }
  }
}

