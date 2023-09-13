package com.example.callscreentheme

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {


    private val PREF_NAME = "app.PhotoCallerPref"
    private var editor: SharedPreferences.Editor? = null
    private var pref: SharedPreferences? = null

    init {
        pref = context.getSharedPreferences("Lang",0)
        editor = pref!!.edit()
    }

    fun addLang(code:String) {
        editor!!.putString("code",code)
        editor!!.commit()
    }

    fun getLang(): String? {
        return pref!!.getString("code","en")
    }


    fun Preference(context: Context) {
        val sharedPreferences = context.getSharedPreferences(PREF_NAME, 0)
        pref = sharedPreferences
        editor = sharedPreferences.edit()
    }

    fun setBoolean(str: String?, bool: Boolean?) {
        editor!!.putBoolean(str, bool!!)
        editor!!.commit()
    }

    fun getBoolean(str: String?): Boolean? {
        return java.lang.Boolean.valueOf(pref!!.getBoolean(str, false))
    }

    fun getBoolean(str: String?, z: Boolean): Boolean? {
        return java.lang.Boolean.valueOf(pref!!.getBoolean(str, z))
    }

    fun setInteger(str: String?, num: Int?) {
        editor!!.putInt(str, num!!)
        editor!!.commit()
    }

    fun getInteger(str: String?): Int? {
        return Integer.valueOf(pref!!.getInt(str, 0))
    }

    fun setString(str: String?, str2: String?) {
        editor!!.putString(str, str2)
        editor!!.commit()
    }

    fun getString(str: String?): String? {
        return pref!!.getString(str, null as String?)
    }

    fun getString(str: String?, str2: String?): String? {
        return pref!!.getString(str, str2)
    }

    fun removePref(str: String?) {
        editor!!.remove(str)
        editor!!.commit()
    }

    fun getStringEmpty(str: String?): String? {
        return pref!!.getString(str, "{}")
    }

    fun clearPrefrence() {
        editor!!.clear()
        editor!!.commit()
    }

    fun edit(): Any {
        TODO("Not yet implemented")
    }


}