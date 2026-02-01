package services

interface ITodoService {
    fun showTodos()
    fun addTodo(title: String)
    fun removeTodo(id: Int)
    fun updateTodo(id: Int, newTitle: String)
    fun searchTodo(keyword: String)
    fun sortTodo(type: Int)


}

