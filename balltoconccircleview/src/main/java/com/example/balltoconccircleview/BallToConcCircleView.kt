package com.example.balltoconccircleview

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas
import android.graphics.RectF

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#3F51B5",
    "#006064",
    "#F57F17",
    "#6A1B9A"
).map {
    Color.parseColor(it)
}.toTypedArray()
val delay : Long = 20
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.9f
val rFactor : Float = 11.2f
val backColor : Int = Color.parseColor("#BDBDBD")
val circles : Int = 2
val parts : Int = circles + 2
val scGap : Float = 0.02f / parts
