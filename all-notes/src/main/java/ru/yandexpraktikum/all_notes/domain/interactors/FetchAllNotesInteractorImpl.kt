package ru.yandexpraktikum.all_notes.domain.interactors

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import ru.yandexpraktikum.core.domain.model.Note
import ru.yandexpraktikum.core.domain.repository.NotesRepository

class FetchAllNotesInteractorImpl @Inject constructor(
    private val repository: NotesRepository
): FetchAllNotesInteractor {
    override fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}
