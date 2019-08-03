package com.medivetfarm.models;

import org.json.JSONArray;
import org.json.JSONObject;

public interface VolleyCallback {
    void onSuccessResponseObject(JSONObject result);
    void onSuccessResponseArray(JSONArray result);
}
