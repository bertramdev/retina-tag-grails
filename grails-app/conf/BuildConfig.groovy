grails.project.class.dir = "target/classes"

grails.project.dependency.resolution = {

	inherits("global")
	log "warn"

	repositories {
		grailsCentral()
		mavenCentral()
	}


	plugins {
		runtime ":asset-pipeline:1.5.6"
		build(":release:2.2.1", ":rest-client-builder:1.0.3") {
			export = false
		}
	}
}
