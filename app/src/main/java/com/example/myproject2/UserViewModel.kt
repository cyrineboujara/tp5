package com.example.myproject2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = DatabaseInstance.getDatabase(application).userDao()

    // Pour insérer un utilisateur dans la base de données
    fun insertUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }

    // Pour récupérer tous les utilisateurs
    fun getAllUsers(onResult: (List<User>) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val users = userDao.getAll()
            onResult(users)
        }
    }
}
