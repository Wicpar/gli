package gli

/**
 * Created by elect on 02/04/17.
 */

enum class Target {
    INVALID,
    _1D,
    _1D_ARRAY,
    _2D,
    _2D_ARRAY,
    _3D,
    RECT,
    RECT_ARRAY,
    CUBE,
    CUBE_ARRAY;

    @JvmField val i = ordinal - 1 // invalid -> -1

    val isTarget1d: Boolean by lazy { this == _1D || this == _1D_ARRAY }
    val isTargetArray: Boolean by lazy { this == _1D_ARRAY || this == _2D_ARRAY || this == CUBE_ARRAY }
    val isTargetCube: Boolean by lazy { this == CUBE || this == CUBE_ARRAY }
    val isTargetRect: Boolean by lazy { this == RECT || this == RECT_ARRAY }

    operator fun rangeTo(that: Target): TargetRange = TargetRange(this, that)

    class TargetRange(override val start: Target, override val endInclusive: Target) : ClosedRange<Target>, Iterable<Target> {
        override fun iterator() = TargetIterator(this)
        override fun contains(value: Target) = value.i in start.i..endInclusive.i
    }

    class TargetIterator(val targetRange: TargetRange) : Iterator<Target> {
        var current = targetRange.start
        override fun next() = Target.values()[current.i + 1]
        override fun hasNext() = current != CUBE_ARRAY
    }
}

val TARGET_FIRST = Target._1D
val TARGET_LAST = Target.CUBE_ARRAY
val TARGET_COUNT = Target.values().size
val TARGET_INVALID = -1