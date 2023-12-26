package com.arcanium.readbuddy.util

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

val now: LocalDateTime
    get() = Clock.System.now().toLocalDateTime(
        TimeZone.currentSystemDefault()
    )

val LocalDateTime.epochSeconds: Long
    get() = toInstant(TimeZone.currentSystemDefault()).epochSeconds

fun fromEpochSeconds(epochSeconds: Long): LocalDateTime {
    return Instant
        .fromEpochSeconds(epochSeconds)
        .toLocalDateTime(TimeZone.currentSystemDefault())
}