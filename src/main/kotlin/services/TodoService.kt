
package services

import entities.Todo
import repositories.ITodoRepository

class TodoService(private val todoRepository: ITodoRepository) : ITodoService {
    override fun showTodos() {
        val todos = todoRepository.getAllTodos()

        println("Daftar Todo:")
        var counter = 0
        for (todo in todos) {
            counter++
            println(todo)
        }

        if (counter <= 0) {
            println("- Data todo belum tersedia!")
        }
    }

    override fun addTodo(title: String) {
        val newTodo = Todo(title = title)
        todoRepository.addTodo(newTodo)
    }

    override fun removeTodo(id: Int) {
        val success = todoRepository.removeTodo(id)
        if (!success) {
            println("[!] Gagal menghapus todo dengan ID: $id.")
            return
        }
    }

    override fun updateTodo(id: Int, newTitle: String) {
        val success = todoRepository.updateTodo(id, newTitle)
        if (!success) {
            println("[!] Todo dengan ID $id tidak ditemukan.")
        }
    }

    override fun searchTodo(keyword: String) {
        val results = todoRepository.search(keyword)

        if (results.isEmpty()) {
            println("- Todo tidak ditemukan.")
            return
        }

        println("Hasil Pencarian:")
        results.forEach { println(it) }
    }

    override fun sortTodo(type: Int) {
        val sorted = when (type) {
            1 -> todoRepository.sortByTitle()
            2 -> todoRepository.sortByStatus()
            else -> return
        }

        println("Hasil Urutan:")
        sorted.forEach { println(it) }
    }

}