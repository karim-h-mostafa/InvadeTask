package com.eitadevelopment.invadetask.domain.map

interface GenericMapper<Input, Output> {
    fun forwardMapping(value: Input): Output
    fun backwardMapping(value: Output): Input
    fun forwardListMapping(valuesList: List<Input>): List<Output> {
        return valuesList.map { dtoItem -> forwardMapping(dtoItem) }
    }

    fun backwardListMapping(valuesList: List<Output>): List<Input> {
        return valuesList.map { dtoItem -> backwardMapping(dtoItem) }
    }

}