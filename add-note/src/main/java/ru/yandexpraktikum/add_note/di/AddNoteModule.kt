package ru.yandexpraktikum.add_note.di

import dagger.Binds
import dagger.Component
import dagger.Module
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractor
import ru.yandexpraktikum.add_note.domain.interactors.AddNoteInteractorImpl
import ru.yandexpraktikum.add_note.presentation.AddNoteViewModelFactory
import ru.yandexpraktikum.core.di.CoreComponent

@Module
interface AddNoteModule {

    @Binds
    @AddNoteScope
    fun bindAddNoteInteractor(impl: AddNoteInteractorImpl): AddNoteInteractor
}

@AddNoteScope
@Component(
    modules = [AddNoteModule::class],
    dependencies = [CoreComponent::class]
)
interface AddNoteComponent {

    fun getAddNoteViewModelFactory(): AddNoteViewModelFactory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AddNoteComponent
    }
}
