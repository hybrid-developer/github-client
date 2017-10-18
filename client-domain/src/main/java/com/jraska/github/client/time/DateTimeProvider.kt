package com.jraska.github.client.time

import org.threeten.bp.LocalDateTime

interface DateTimeProvider {
    fun now(): LocalDateTime
}