FROM jenkins/jenkins:latest

#####
# Install our plug-ins
#####
COPY plugins.txt $JENKINS_HOME/plugins.txt
RUN /usr/local/bin/plugins.sh plugins.txt

#####
# Configure Jenkins using configuration-as-code yaml
#####
RUN mkdir -p /usr/share/jenkins/config/as-code/
COPY as-code /usr/share/jenkins/config/as-code
ENV CASC_JENKINS_CONFIG  /usr/share/jenkins/config/as-code


# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false