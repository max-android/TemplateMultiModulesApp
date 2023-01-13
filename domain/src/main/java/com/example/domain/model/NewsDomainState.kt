package com.example.domain.model

sealed interface NewsDomainResult

class NewsDomainSuccess(val data: List<NewsModel>) : NewsDomainResult
class NewsDomainError(val code: Int, val message: String?) : NewsDomainResult
class NewsDomainException(val throwable: Throwable) : NewsDomainResult