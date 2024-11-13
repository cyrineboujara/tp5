package com.example.myproject2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseInstance.getDatabase(applicationContext)
        val userDao = db.userDao()

        // Pour insérer un utilisateur
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(User(uid = 1, firstName = "John", lastName = "Doe"))
        }

        // Pour récupérer tous les utilisateurs
        CoroutineScope(Dispatchers.IO).launch {
            val users: List<User> = userDao.getAll()
            // Traitez les utilisateurs ici, par exemple en les affichant dans l'UI
        }
    }
}
