package org.sopt.at.data.service

import org.json.JSONObject

fun jsonToErrorMessage(json: String?): String? {
    return try {
        val jsonObject = JSONObject(json ?: return null)
        jsonObject.optString("message")
    } catch (e: Exception) {
        null
    }
}