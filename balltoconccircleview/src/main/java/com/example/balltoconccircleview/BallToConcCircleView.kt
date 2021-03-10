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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBallToConcentricCircle(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val r : Float = Math.min(w, h) / rFactor
    val sf : Float = scale.sinify()
    save()
    translate(w / 2, h / 2)
    for (j in 0..1) {
        val sfj : Float = sf.divideScale(2 * j + 1, parts)
        val cr : Float = size - size * 0.5f * j
        save()
        rotate(360f * sfj)
        paint.style = Paint.Style.FILL
        drawCircle(
            size - size * 0.5f * j,
            0f,

            r * sf.divideScale(2 * j, parts),
            paint
        )
        paint.style = Paint.Style.STROKE
        drawArc(RectF(-cr, -cr, cr, cr), 0f, 360f * sfj, false, paint)
        restore()
    }
    restore()
}

fun Canvas.drawBTCCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawBallToConcentricCircle(scale, w, h, paint)
}

class BallToConcentricCircle(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean{
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}