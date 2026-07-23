package com.spaceumbrella.domain.model.category

import java.time.ZonedDateTime

/**
 *
 */
case class Category
(
  id: Long,
  name: String,
  description: Option[String],
  parentId: Option[Long]
)

