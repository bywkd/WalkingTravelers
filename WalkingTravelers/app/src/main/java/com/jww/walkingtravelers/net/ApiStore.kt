package com.jww.walkingtravelers.net

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.jww.walkingtravelers.WTApp

class ApiStore {
    companion object {
        fun addUser(document:String): DocumentReference {
            return WTApp().getDB().collection("user").document(document)
        }
    }
}