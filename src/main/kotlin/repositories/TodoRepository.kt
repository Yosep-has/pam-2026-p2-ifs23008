package repositories

import entities.Todo

class TodoRepository : ITodoRepository {
    val data = ArrayList<Todo>()

    override fun getAllTodos(): ArrayList<Todo> {
        return data
    }

    override fun addTodo(newTodo: Todo) {
        data.add(newTodo)
    }

    override fun removeTodo(id: Int): Boolean {
        val targetTodo = data
            .find { it.id == id }

        if (targetTodo == null) {
            return false
        }

        data.remove(targetTodo)
        return true
    }

    override fun updateTodo(id: Int, newTitle: String): Boolean {
        val todo = data.find { it.id == id } ?: return false
        todo.title = newTitle
        return true
    }

    override fun search(keyword: String): List<Todo> {
        return data.filter {
            it.title.contains(keyword, ignoreCase = true)
        }
    }
    override fun sortByTitle(): List<Todo> {
        return data.sortedBy { it.title }
    }

    override fun sortByStatus(): List<Todo> {
        return data.sortedBy { it.isFinished }
    }



}