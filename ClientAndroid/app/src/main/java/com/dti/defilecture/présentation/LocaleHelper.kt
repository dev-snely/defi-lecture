package com.dti.defilecture.présentation

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import androidx.preference.PreferenceManager
import java.util.*

class LocaleHelper (var context: Context){
    fun onCreate() {
        val lang: String?
        lang = if (getLanguage()!!.isEmpty()) {
            getPersistedData(Locale.getDefault().language)
        } else {
            getLanguage()
        }
        setLocale(lang)
    }

    fun onCreate(defaultLanguage: String) {
        val lang = getPersistedData(defaultLanguage)
        setLocale(lang)
    }

    fun getLanguage(): String? {
        return getPersistedData(Locale.getDefault().language)
    }

    fun setLocale(language: String?) {
        persist(language)
        updateResources(language)
    }

    private fun getPersistedData(defaultLanguage: String): String? {
        val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
    }

    private fun persist(language: String?) {
        val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    private fun updateResources(language: String?) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources: Resources = context.resources
        val configuration: Configuration = resources.configuration
        configuration.locale = locale
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    companion object {
        private const val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"
    }
}

