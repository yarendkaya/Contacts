package com.yarendemirkaya.contacts.di

import com.yarendemirkaya.contacts.data.datasource.ContactsDataSource
import com.yarendemirkaya.contacts.data.repo.ContactsRepository
import com.yarendemirkaya.contacts.retrofit.ApiUtils
import com.yarendemirkaya.contacts.retrofit.PersonDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsRepository(contactsDataSource: ContactsDataSource): ContactsRepository {
        return ContactsRepository(contactsDataSource)
    }

    @Provides
    @Singleton
    fun providePersonDataSource(personDAO: PersonDAO): ContactsDataSource {
        return ContactsDataSource(personDAO)
    }
    @Provides
    @Singleton
    fun providePersonDAO(): PersonDAO {
        return ApiUtils.getPersonDao()
    }


}