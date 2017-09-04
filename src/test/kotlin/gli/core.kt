package gli

import glm_.vec2.Vec2i
import glm_.vec4.Vec4b
import io.kotlintest.specs.StringSpec

class core : StringSpec() {

    init {

        "create texture storage" {

            val texture = Texture2d(Format.RGBA8_UINT_PACK8, Vec2i(256))
            texture.clear(Vec4b())
        }
    }
}