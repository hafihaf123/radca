package com.hafihaf.radca.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreDruzContent(private val context: Context) {

//    to make sure there is only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DruzContent")
        val DRUZ_CONTENT_KEY = stringPreferencesKey("druz_content")
    }

//    to get the druzinovka content
    val getDruzContent: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[DRUZ_CONTENT_KEY] ?: ""
        }

//    to save the druzinovka content
    suspend fun saveDruzContent(name: String) {
        context.dataStore.edit { preferences ->
            preferences[DRUZ_CONTENT_KEY] = name
        }
    }
}