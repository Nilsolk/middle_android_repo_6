package ru.yandexpraktikum.notekeeper.di

import ru.yandexpraktikum.add_note.di.AddNoteComponent
import ru.yandexpraktikum.add_note.di.DaggerAddNoteComponent
import ru.yandexpraktikum.all_notes.di.AllNotesComponent
import ru.yandexpraktikum.all_notes.di.DaggerAllNotesComponent
import ru.yandexpraktikum.core.di.CoreComponent

class ComponentProvider(
    private val coreComponent: CoreComponent
) {
    private var allNotesComponent: AllNotesComponent? = null
    private var addNoteComponent: AddNoteComponent? = null

    fun initAllNotesComponent(): AllNotesComponent {
        if (allNotesComponent == null) {
            allNotesComponent = DaggerAllNotesComponent.factory().create(coreComponent)
        }
        return allNotesComponent!!
    }

    fun clearAllNotesComponent() {
        allNotesComponent = null
    }

    fun initAddNoteComponent(): AddNoteComponent {
        if (addNoteComponent == null) {
            addNoteComponent = DaggerAddNoteComponent.factory().create(coreComponent)
        }
        return addNoteComponent!!
    }

    fun clearAddNoteComponent() {
        addNoteComponent = null
    }
}
