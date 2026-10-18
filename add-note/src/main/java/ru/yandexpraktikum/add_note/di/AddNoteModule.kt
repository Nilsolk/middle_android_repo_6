package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModelFactory

@Module
interface AddNoteModule {

    @Binds
    @AddNoteScope
    fun bindAddNoteInteractor(impl: AddNoteInteractorImpl): AddNoteInteractor
}

@AddNoteScope
@Subcomponent(modules = [AddNoteModule::class])
interface AddNoteSubcomponent {

    fun addNoteViewModelFactory(): AddNoteViewModelFactory

    @Subcomponent.Factory
    interface Factory {
        fun create(): AddNoteSubcomponent
    }
}
