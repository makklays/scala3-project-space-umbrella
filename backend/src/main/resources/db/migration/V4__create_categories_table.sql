-- V4__create_categories_table.sql
-- Migration #4: create table categories

-- Creating table 'categories' for saving main data of categories
CREATE TABLE IF NOT EXISTS categories
(
    id          BIGSERIAL PRIMARY KEY,

    title       VARCHAR(255) NOT NULL,       -- Title of the blog post
    description TEXT NOT NULL,               -- Description of the category

    created_at  TIMESTAMP WITH TIME ZONE DEFAULT now()
);

-- Indexes for faster lookups
CREATE INDEX idx_categories_title ON categories(title);

