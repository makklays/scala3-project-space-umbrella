package com.spaceumbrella.domain.category

import java.time.ZonedDateTime
import java.time.Instant

/**
 * Category model
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
case class Category(
  id: Option[CategoryId] = None, // Используем обертку вместо Option[Long]
  title: String,
  description: String,
  createdAt: Instant = Instant.now()
)

