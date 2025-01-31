/*
 * Copyright (c) 2024 ModCore Inc. All rights reserved.
 *
 * This code is part of ModCore Inc.'s Essential Mod repository and is protected
 * under copyright registration # TX0009138511. For the full license, see:
 * https://github.com/EssentialGG/Essential/blob/main/LICENSE
 *
 * You may not use, copy, reproduce, modify, sell, license, distribute,
 * commercialize, or otherwise exploit, or create derivative works based
 * upon, this file or any other in this repository, all of which is reserved by Essential.
 */
package gg.essential.util

import java.io.IOException

// Older MC uses toString to display the error on the "Failed to connect to server" screen
open class PrettyIOException(message: String, cause: Throwable? = null) : IOException(message, cause) {
    override fun toString(): String {
        return message!!
    }
}
