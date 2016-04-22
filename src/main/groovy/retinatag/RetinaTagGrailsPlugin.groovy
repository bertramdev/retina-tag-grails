package retinatag

import grails.plugins.*

class RetinaTagGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.1.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Retina Tag Plugin"
    def author = "David Estes"
    def authorEmail = "destes@bcap.com"
    def description = "Adds retina resolution image tag support for asset-pipeline."
    def documentation = "http://github.com/bertramdev/retina-tag-grails"

    def license = "APACHE"
    def organization = [ name: "Bertram Capital", url: "http://www.bertramcapital.com/" ]
    def issueManagement = [ system: "GITHUB", url: "http://github.com/bertramdev/retina-tag-grails/issues" ]
    def scm = [ url: "http://github.com/bertramdev/retina-tag-grails" ]


    void doWithDynamicMethods() {
        println "Initializing Dynamic Methods"
        def ctx = applicationContext
        def assetTagLib  = ctx.getBean('asset.pipeline.grails.AssetsTagLib')
        def retinaTagLib = ctx.getBean('retinatag.RetinaTagLib')
        assetTagLib.image = retinaTagLib.image
    }
    
}
