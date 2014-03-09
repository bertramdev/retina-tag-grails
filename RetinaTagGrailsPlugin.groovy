import org.codehaus.groovy.grails.commons.*
import asset.pipeline.*

class RetinaTagGrailsPlugin {
    def version = "1.1.0"
    def grailsVersion = "2.0 > *"
    def title = "Retina Tag Plugin"
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = "Adds retina resolution image tag support for asset-pipeline."
    def documentation = "http://github.com/bertramdev/retina-tag-grails"

    def license = "APACHE"
    def organization = [ name: "Bertram Capital", url: "http://www.bertramcapital.com/" ]
    def issueManagement = [ system: "GITHUB", url: "http://github.com/bertramdev/retina-tag-grails/issues" ]
    def scm = [ url: "http://github.com/bertramdev/retina-tag-grails" ]

    def doWithDynamicMethods = { ctx ->
        def assetTagLib  = ctx.getBean('asset.pipeline.AssetsTagLib')
        def retinaTagLib = ctx.getBean('retinatag.RetinaTagLib')
        assetTagLib.image = retinaTagLib.image
    }

}
