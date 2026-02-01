package repositories

import entities.Todo

interface ITodoRepository {
    fun getAllTodos(): List<Todo>
    fun addTodo(newTodo: Todo)
    fun removeTodo(id: Int): Boolean
    fun updateTodo(id: Int, newTitle: String): Boolean
    fun search(keyword: String): List<Todo>
    fun sortByTitle(): List<Todo>
    fun sortByStatus(): List<Todo>




}