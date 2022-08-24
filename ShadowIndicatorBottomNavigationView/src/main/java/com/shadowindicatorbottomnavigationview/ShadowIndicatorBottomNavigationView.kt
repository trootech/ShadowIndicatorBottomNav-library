package com.shadowindicatorbottomnavigationview


import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.doOnPreDraw
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.abs


private const val DEFAULT_SCALE = 1f
private const val MAX_SCALE = 1f
private const val BASE_DURATION = 300L
private const val VARIABLE_DURATION = 300L

class ShadowIndicatorBottomNavigationView : BottomNavigationView,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private var externalSelectedListener: OnNavigationItemSelectedListener? = null
    private var animator: ValueAnimator? = null

    private val indicator = RectF()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, R.color.white)
    }

    private val shadow = RectF()
    private val shadowPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL

    }
    var path = Path()

    private var indicatorShadowColor = Color.WHITE
    private var indicatorHeaderColor = Color.WHITE
    private var indicatorHeaderHeight = 20f
    private var indicatorShadowVisible = true

    private val defaultSize = 70f

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
        attrs?.apply {
            val ta = context.obtainStyledAttributes(this, R.styleable.ShadowIndicatorBottomNavigationView)
            indicatorHeaderHeight = ta.getDimension(R.styleable.ShadowIndicatorBottomNavigationView_indicatorHeaderHeight, indicatorHeaderHeight)
            indicatorHeaderColor = ta.getColor(R.styleable.ShadowIndicatorBottomNavigationView_indicatorHeaderColor, indicatorHeaderColor)
            indicatorShadowColor = ta.getColor(R.styleable.ShadowIndicatorBottomNavigationView_indicatorShadowColor, indicatorShadowColor)
            indicatorShadowVisible = ta.getBoolean(R.styleable.ShadowIndicatorBottomNavigationView_indicatorShadowVisible, indicatorShadowVisible)

            ta.recycle()
        }

    }

    init {
        super.setOnNavigationItemSelectedListener(this)
    }

//    override fun getMaxItemCount(): Int {
//        return 6
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (externalSelectedListener?.onNavigationItemSelected(item) != false) {
            onItemSelected(item.itemId)
            return true
        }
        return false
    }

    override fun setOnNavigationItemSelectedListener(listener: OnNavigationItemSelectedListener?) {
        externalSelectedListener = listener
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        doOnPreDraw {
            // Move the indicator in place when the view is laid out
            onItemSelected(selectedItemId, false)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        // Clean up the animator if the view is going away
        cancelAnimator(setEndValues = true)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (isLaidOut) {
            val cornerRadius = indicator.height() / 2f
            paint.color = indicatorHeaderColor
            canvas.drawRoundRect(indicator, cornerRadius, cornerRadius, paint)
//            canvas.drawRoundRect(shadow, 0f, 0f, paint)
            if (indicatorShadowVisible) {
                canvas.drawPath(path, shadowPaint)
            }
        }
    }

    private fun onItemSelected(itemId: Int, animate: Boolean = true) {
        if (!isLaidOut) return

        // Interrupt any current animation, but don't set the end values,
        // if it's in the middle of a movement we want it to start from
        // the current position, to make the transition smoother.
        cancelAnimator(setEndValues = false)

        val itemView = findViewById<View>(itemId) ?: return
        val fromCenterX = indicator.centerX()
        val fromScale = indicator.width() / defaultSize

        animator = ValueAnimator.ofFloat(MAX_SCALE, fromScale, DEFAULT_SCALE).apply {
            addUpdateListener {
                val progress = it.animatedFraction
                val distanceTravelled = linearInterpolation(progress, fromCenterX, itemView.centerX)

                val scale = it.animatedValue as Float
                val indicatorWidth = defaultSize * 1.2f * scale

                val left = distanceTravelled - indicatorWidth + defaultSize / 3
                val top = indicator.top//height - bottomOffset - defaultSize
                val right = distanceTravelled + indicatorWidth - defaultSize / 3
                val bottom = indicator.top + indicatorHeaderHeight

                indicator.set(left, top, right, bottom)

                val leftShadow = (indicator.centerX() - indicator.width() / 2) + indicatorHeaderHeight / 2
                val topShadow = itemView.top + indicatorHeaderHeight//height - bottomOffset - defaultSize
                val rightShadow = (indicator.centerX() + indicator.width() / 2) - indicatorHeaderHeight / 2
                val bottomShadow = itemView.bottom.toFloat()

                shadowPaint.shader = LinearGradient(0f, 0f, 0f, itemView.height.toFloat(), intArrayOf(getColorWithAlpha(indicatorShadowColor, 40), Color.TRANSPARENT), null, Shader.TileMode.CLAMP)

                shadow.set(leftShadow, topShadow.toFloat(), rightShadow, bottomShadow.toFloat())
                path = Path()
                path.apply {
//                    addRect(shadow, Path.Direction.CW)
                    moveTo(shadow.centerX() - shadow.width() / 2, shadow.centerY() - shadow.height() / 2)
//                    addCircle(shadow.centerX() - shadow.width() / 2, shadow.centerY() - shadow.height() / 2, 10f, Path.Direction.CW) // Left Top
                    lineTo(shadow.centerX() + shadow.width() / 2, shadow.centerY() - shadow.height() / 2)
//                    addCircle(shadow.centerX() + shadow.width() / 2, shadow.centerY() - shadow.height() / 2, 10f, Path.Direction.CW) // Right Top
                    lineTo(shadow.centerX() + shadow.width() / 2 + defaultSize / 2, shadow.centerY() + shadow.height() / 2)
//                    addCircle(shadow.centerX() + shadow.width() / 2 + defaultSize, shadow.centerY() + shadow.height() / 2, 10f, Path.Direction.CW) // Right Bottom
                    lineTo(shadow.centerX() - shadow.width() / 2 - defaultSize / 2, shadow.centerY() + shadow.height() / 2)
//                    addCircle(shadow.centerX() - shadow.width() / 2 - defaultSize, shadow.centerY() + shadow.height() / 2, 10f, Path.Direction.CW) // Left Bottom
                    lineTo(shadow.centerX() - shadow.width() / 2, shadow.centerY() - shadow.height() / 2)
                }

                invalidate()
            }

            interpolator = LinearOutSlowInInterpolator()

            val distanceToMove = abs(fromCenterX - itemView.centerX)
            duration = if (animate) calculateDuration(distanceToMove) else 0L

            start()
        }
    }

    private fun getColorWithAlpha(color: Int, ratio: Int): Int {
//        return Color.argb((Color.alpha(color) * ratio).roundToInt(), Color.red(color), Color.green(color), Color.blue(color))
        return ColorUtils.setAlphaComponent(color, ((ratio * 255) / 100).toInt())

    }

    /**
     * Linear interpolation between 'a' and 'b' based on the progress 't'
     */
    private fun linearInterpolation(t: Float, a: Float, b: Float) = (1 - t) * a + t * b

    /**
     * Calculates a duration for the translation based on a fixed duration + a duration
     * based on the distance the indicator is being moved.
     */
    private fun calculateDuration(distance: Float) =
        (BASE_DURATION + VARIABLE_DURATION * (distance / width).coerceIn(0f, 1f)).toLong()

    /**
     * Convenience property for getting the center X value of a View
     */
    private val View.centerX get() = left + width / 2f

    private fun cancelAnimator(setEndValues: Boolean) = animator?.let {
        if (setEndValues) {
            it.end()
        } else {
            it.cancel()
        }
        it.removeAllUpdateListeners()
        animator = null
    }
}