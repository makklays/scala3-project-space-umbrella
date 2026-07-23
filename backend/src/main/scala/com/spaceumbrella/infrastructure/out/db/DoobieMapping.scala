package com.spaceumbrella.infrastructure.out.db

import com.spaceumbrella.domain.category.CategoryId
import doobie.Meta

/**
 * Объект, содержащий implicit маппинги для doobie.
 * Здесь мы определяем, как наши Value Objects и другие типы данных будут преобразовываться в SQL типы и обратно.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
trait DoobieMapping {
  // Автоматический маппинг для нашего Value Object CategoryId
  implicit val categoryIdMeta: Meta[CategoryId] =
    Meta[Long].imap(CategoryId.apply)(_.value)

  // Маппинг для Instant (если не подтянулся автоматически из doobie.postgres.implicits)
  implicit val instantMeta: Meta[java.time.Instant] =
    Meta[java.sql.Timestamp].imap(_.toInstant)(java.sql.Timestamp.from)
}

