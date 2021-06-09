package com.poseidon.wanandroid.di

import com.poseidon.blc.knowledge.service.KnowledgeService
import com.poseidon.blc.knowledge.usecase.KnowledgeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class KnowledgeModule {

    @Provides
    fun getKnowledgeService(retrofit: Retrofit): KnowledgeService {
        return retrofit.create(KnowledgeService::class.java)
    }

    @Provides
    fun getKnowledgeUseCase(knowledgeService: KnowledgeService): KnowledgeUseCase {
        return KnowledgeUseCase(knowledgeService = knowledgeService)
    }
}