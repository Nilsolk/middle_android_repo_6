package ru.yandexpraktikum.notekeeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.yandexpraktikum.core_ui.presentation.theme.NoteKeeperTheme
import ru.yandexpraktikum.notekeeper.di.ApplicationComponent
import ru.yandexpraktikum.notekeeper.presentation.navigation.NoteKeeperNavHost

class MainActivity : ComponentActivity() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        applicationComponent = (application as NoteKeeperApp).applicationComponent

        setContent {
            NoteKeeperTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NoteKeeperNavHost(
                        applicationComponent = applicationComponent,
                        navController = navController
                    )
                }
            }
        }
    }
}
