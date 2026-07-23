package com.spaceumbrella.application.command

/**
 * Command to create a new category.
 *
 * @author Alexander Kuziv <makklays@gmail.com>
 * @company TechMatrix18
 * @version 0.0.1
 * @since 23.07.2026
 */

// Добавляем поля, без которых создание категории физически невозможно
case class CreateCategoryCmd(
  title: String,
  description: String
)

