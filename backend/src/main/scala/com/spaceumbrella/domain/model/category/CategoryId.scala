package com.spaceumbrella.domain.model.category

/**
 * CategoryId - это value class, который оборачивает Long.
 * extends AnyVal заставляет компилятор использовать под капотом обычный Long,
 * но на этапе компиляции гарантирует строгую проверку типов.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */
case class CategoryId(value: Long) extends AnyVal {
  // Пример простой валидации при создании (опционально)
  require(value > 0, "Category ID must be greater than zero")
}

