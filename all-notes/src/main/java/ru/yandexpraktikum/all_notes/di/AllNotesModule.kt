package ru.yandexpraktikum.all_notes.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.DeleteNoteInteractorImpl
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractor
import ru.yandexpraktikum.all_notes.domain.interactors.FetchAllNotesInteractorImpl
import ru.yandexpraktikum.all_notes.presentation.AllNotesViewModelFactory
import ru.yandexpraktikum.core.di.CoreComponent

@Module
interface AllNotesModule {

    @Binds
    @AllNotesScope
    fun bindFetchAllNotesInteractor(impl: FetchAllNotesInteractorImpl): FetchAllNotesInteractor

    @Binds
    @AllNotesScope
    fun bindDeleteNoteInteractor(impl: DeleteNoteInteractorImpl): DeleteNoteInteractor
}

@AllNotesScope
@Component(
    modules = [AllNotesModule::class],
    dependencies = [CoreComponent::class]
)
interface AllNotesComponent {

    fun getAllNotesViewModelFactory(): AllNotesViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AllNotesComponent
    }
}
