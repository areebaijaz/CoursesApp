package com.example.grids

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Grid(
    @StringRes val stringresourceId : Int,
   val lessonsId : Int,
    @DrawableRes val imageresourceId : Int
) {

}
