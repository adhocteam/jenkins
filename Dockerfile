FROM jenkins/jenkins:latest

COPY plugins.txt $JENKINS_HOME/plugins.txt

RUN /usr/local/bin/plugins.sh plugins.txt

ENV JENKINS_USER adhoc

# Provide this at run time
# ENV JENKINS_PASS

# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY default-user.groovy /usr/share/jenkins/ref/init.groovy.d/