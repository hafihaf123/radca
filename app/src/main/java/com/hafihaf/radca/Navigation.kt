package com.hafihaf.radca

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hafihaf.radca.ui.todo.add_edit_todo.AddEditTodoScreen
import com.hafihaf.radca.ui.todo.todo_list.TodoListScreen
import com.hafihaf.radca.util.Routes

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.DRUZINOVKA) {
        composable(route = Routes.DRUZINOVKA) { DruzinovkaScreen(
            onNavigate = { navController.navigate(it.route) }
        ) }
        navigation(startDestination = Routes.TODO_LIST, route = Routes.TODO) {
            composable(route = Routes.TODO_LIST) {
                TodoListScreen(
                    onNavigate = { navController.navigate(it.route) }
                )
            }
            composable(
                route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                arguments = listOf(
                    navArgument(name = "todoId") {
                        type = NavType.IntType
                        defaultValue = -1
                    }
                )
            ) {
                AddEditTodoScreen(onPopBackStack = {
                    navController.popBackStack()
                })
            }
        }
    }
}