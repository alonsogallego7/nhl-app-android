package com.alonsogp.nhl_app.app.presentation.glide

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import java.io.IOException
import java.io.InputStream


class SvgDecoder : ResourceDecoder<InputStream?, SVG?> {
    override fun handles(source: InputStream, options: Options): Boolean {
        // TODO: Can we tell?
        return true
    }

    @Throws(IOException::class)
    override fun decode(
        source: InputStream, width: Int, height: Int, options: Options
    ): Resource<SVG?>? {
        return try {
            val svg = SVG.getFromInputStream(source)
            if (width != SIZE_ORIGINAL) {
                svg.documentWidth = 230F
            }
            if (height != SIZE_ORIGINAL) {
                svg.documentHeight = 150F
            }
            SimpleResource<SVG>(svg)
        } catch (ex: SVGParseException) {
            throw IOException("Cannot load SVG from stream", ex)
        }
    }
}