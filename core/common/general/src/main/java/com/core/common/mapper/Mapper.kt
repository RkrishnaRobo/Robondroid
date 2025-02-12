package com.core.common.mapper

interface Mapper<T, R> {
    fun map(param: T): R
}
