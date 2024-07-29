package com.collanquiandres.nutri

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class UserWelcomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_welcome)

        auth = FirebaseAuth.getInstance()

        val userInfoTextView: TextView = findViewById(R.id.userInfo)
        val changeNameButton: Button = findViewById(R.id.changeNameButton)
        val changePasswordButton: Button = findViewById(R.id.changePasswordButton)
        val logoutButton: Button = findViewById(R.id.logoutButton)
        val startButton: Button = findViewById(R.id.startButton)

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val email = currentUser.email
            val displayName = currentUser.displayName ?: "Usuario"
            userInfoTextView.text = "Usuario: $displayName\nCorreo: $email"
        }

        changeNameButton.setOnClickListener {
            showChangeNameDialog(userInfoTextView)
        }

        changePasswordButton.setOnClickListener {
            showChangePasswordDialog()
        }

        logoutButton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }

        startButton.setOnClickListener {
            startActivity(Intent(this, RecetasActivity::class.java))
        }
    }

    private fun showChangeNameDialog(userInfoTextView: TextView) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Cambiar Nombre")

        val input = EditText(this)
        builder.setView(input)

        builder.setPositiveButton("Guardar") { dialog, _ ->
            val newName = input.text.toString()
            val currentUser = auth.currentUser
            if (currentUser != null && newName.isNotEmpty()) {
                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName(newName)
                    .build()
                currentUser.updateProfile(profileUpdates)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Nombre actualizado", Toast.LENGTH_SHORT).show()
                            val email = currentUser.email
                            userInfoTextView.text = "Usuario: $newName\nCorreo: $email"
                        } else {
                            Toast.makeText(this, "Error al actualizar nombre", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, ingrese un nombre válido", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }

    private fun showChangePasswordDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Cambiar Contraseña")

        val input = EditText(this)
        input.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        builder.setView(input)

        builder.setPositiveButton("Guardar") { dialog, _ ->
            val newPassword = input.text.toString()
            val currentUser = auth.currentUser
            if (currentUser != null && newPassword.isNotEmpty()) {
                currentUser.updatePassword(newPassword)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Contraseña actualizada", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Error al actualizar contraseña", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, ingrese una contraseña válida", Toast.LENGTH_SHORT).show()
            }
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}




