package com.morganz.skyCast.ui.utils

import androidx.compose.ui.graphics.Color

 fun Color.adjustBrightness(factor: Float): Color {
    return Color(this.red * factor, this.green * factor, this.blue * factor, this.alpha)
}