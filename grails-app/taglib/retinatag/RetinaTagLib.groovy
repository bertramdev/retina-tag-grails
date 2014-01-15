package retinatag

import grails.util.Environment
import asset.pipeline.*

class RetinaTagLib extends AssetsTagLib {

	static namespace = "retina"

	def image = { attrs ->
		def src = attrs.remove('src')
		if(!src) {
			return
		}
		def retinaElements = src.toString().split(/\./)
		println retinaElements
    def extension = retinaElements[retinaElements.size() - 1]
    def fileName = retinaElements[0..retinaElements.size()-2].join(".")
    def retinaPath = "${fileName}@2x.${extension}"

    // Lets test if retina equivalent exists
    def retinaAsset = assetPathExists(src:retinaPath) ? assetPath(retinaPath) : null
    println retinaAsset
    if(retinaAsset) {
    	attrs["hidpi_src"] = retinaAsset
    }

		out << "<img src=\"${assetPath(src)}\" ${paramsToHtmlAttr(attrs)}/>"
	}

}
