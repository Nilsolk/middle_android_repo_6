package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.yandexpraktikum.add_note.di.AddNoteSubcomponent
import ru.yandexpraktikum.add_note.presentation.AddNoteScreen
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModel
import ru.yandexpraktikum.all_notes.di.AllNotesSubcomponent
import ru.yandexpraktikum.all_notes.presentation.AllNotesScreen
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModel
import ru.yandexpraktikum.notekeeper.di.ApplicationComponent

@Composable
fun NoteKeeperNavHost(
    applicationComponent: ApplicationComponent,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        composable(route = Screen.AllNotes.route) {
            var allNotesSubcomponent by remember { mutableStateOf<AllNotesSubcomponent?>(null) }
            DisposableEffect(Unit) {
                allNotesSubcomponent = applicationComponent.allNotesSubcomponentFactory().create()
                onDispose {
                    allNotesSubcomponent = null
                }
            }
            val vm: AllNotesViewModel = viewModel(
                factory = allNotesSubcomponent?.allNotesViewModelFactory()
            )
            AllNotesScreen(
                viewModel = vm,
                onAddNoteClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            )
        }
        composable(route = Screen.AddNote.route) {
            var addNoteSubcomponent by remember { mutableStateOf<AddNoteSubcomponent?>(null) }
            DisposableEffect(Unit) {
                addNoteSubcomponent = applicationComponent.addNoteSubcomponentFactory().create()
                onDispose {
                    addNoteSubcomponent = null
                }
            }
            val vm: AddNoteViewModel = viewModel(
                factory = addNoteSubcomponent?.addNoteViewModelFactory()
            )
            AddNoteScreen(
                viewModel = vm,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
