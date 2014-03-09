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
	    def extension = retinaElements[retinaElements.size() - 1]
	    def fileName = retinaElements[0..retinaElements.size()-2].join(".")
	    def retinaPath = "${fileName}@2x.${extension}"

	    // Lets test if retina equivalent exists
	    	    
	    def retinaAsset = isAssetPath(retinaPath) ? assetPath(src:retinaPath) : null
	    
	    if(retinaAsset) {
	    	attrs["data-hidpi-src"] = retinaAsset
	    }

		out << "<img src=\"${assetPath(src:src)}\" ${paramsToHtmlAttr(attrs)}/>"
	}

	private paramsToHtmlAttr(attrs) {
		attrs.collect { key, value -> "${key}=\"${value.toString().replace('\'', '\\\'')}\"" }?.join(" ")
	}

}
