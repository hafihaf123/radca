package com.hafihaf.radca.di

import android.content.Context
import androidx.room.Room
import com.hafihaf.radca.data.todo.TodoDao
import com.hafihaf.radca.data.todo.TodoDatabase
import com.hafihaf.radca.data.todo.TodoRepository
import com.hafihaf.radca.data.todo.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoDatabase(/*app: TodoApp*/@ApplicationContext appContext: Context): TodoDatabase {
        return Room.databaseBuilder(
            appContext,
            TodoDatabase::class.java,
            "todo_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: TodoDatabase) : TodoDao {
        return appDatabase.todoDao()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository {
        return TodoRepositoryImpl(todoDao)
    }
}