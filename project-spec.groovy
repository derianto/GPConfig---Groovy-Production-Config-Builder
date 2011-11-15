// Available in two formats: 1. JSON 2. Groovy

// Spec
spec = [
  "name": "gpconfig",
  "group": "org.dk",
  "version": "0.1.0-SNAPSHOT",
  "owners":[
    "deriantok@gmail.com"
  ],

  // Information about the build framework itself
  "build": [
    type: "gradle",
    version: "1.0-milestone-5",
    uri: "http://gradle.artifactoryonline.com/gradle/distributions/gradle-1.0-milestone-5-all.zip",
    commands: [
      "snapshot": "gradle release",
      "release": "gradle -Prelease=true release"
    ]
  ],

  // External dependencies
  "external": [
    "jacksonMapper": "org.codehaus.jackson:jackson-mapper-asl:1.9.1",
    "junit": "junit:junit:4.8.2",
    "log4j": "log4j:log4j:1.2.15",
    "servletApi": "javax.servlet:servlet-api:2.5",
  ],

  "product": [
  ],

  // Context path by service name
  "context-path": [
    "app-bps": "appbps",
    "app-gui": "appgui",
    "data-service": "dataservice"
  ]
]
