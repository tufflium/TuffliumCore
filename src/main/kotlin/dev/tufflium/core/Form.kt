package dev.tufflium.core

import cn.nukkit.Player
import cn.nukkit.form.window.FormWindowModal

class Form {
    companion object {
        fun createModalForm(
            name: String,
            content: String,
            handler: (Player, Int) -> Unit,
            yesButtonText: String = "gui.yes",
            noButtonText: String = "gui.no"
        ) {
            return FormWindowModal(name, content, yesButtonText, noButtonText).addHandler(handler)
        }
    }
}