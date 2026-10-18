package ru.yandexpraktikum.notekeeper.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.yandexpraktikum.add_note.di.AddNoteSubcomponent
import ru.yandexpraktikum.all_notes.di.AllNotesSubcomponent
import ru.yandexpraktikum.core.di.CoreModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [CoreModule::class]
)
interface ApplicationComponent {

    fun addNoteSubcomponentFactory(): AddNoteSubcomponent.Factory

    fun allNotesSubcomponentFactory(): AllNotesSubcomponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}
