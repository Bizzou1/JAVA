# Use the official code-server image as the base
FROM codercom/code-server:latest

# Switch to root user to install Java
USER root

# Install Java 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

# Set environment variables for Java
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# Switch back to the original user (if needed)
USER coder

# Expose the port for code-server
EXPOSE 8443

# Start code-server (in case it’s not handled by the base image)
CMD ["code-server", "--bind-addr", "0.0.0.0:8443", "--auth", "none", "/workspace"]
