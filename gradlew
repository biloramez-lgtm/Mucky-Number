#!/usr/bin/env sh

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

set -e

APP_HOME=$( cd "${APP_HOME:-/home/gradle}" && pwd -P ) || exit

APP_JAR="${APP_HOME}/gradle/wrapper/gradle-wrapper.jar"
CLASSPATH="${APP_HOME}/gradle/wrapper/gradle-wrapper.jar"

if [ -z "$JAVA_HOME" ] ; then
    JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
fi

exec "$JAVA_HOME/bin/java" \
  -Xmx64m \
  -Dorg.gradle.appname="$APP_BASE_NAME" \
  -classpath "$CLASSPATH" \
  org.gradle.wrapper.GradleWrapperMain "$@"
