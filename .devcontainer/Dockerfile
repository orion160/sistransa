# syntax=docker/dockerfile:1

FROM mcr.microsoft.com/devcontainers/base:noble

RUN sudo apt update && \
sudo apt install -y \
wget apt-transport-https gpg

RUN wget -qO - https://packages.adoptium.net/artifactory/api/gpg/key/public | gpg --dearmor | sudo tee /etc/apt/trusted.gpg.d/adoptium.gpg > /dev/null && \
echo "deb https://packages.adoptium.net/artifactory/deb $(awk -F= '/^VERSION_CODENAME/{print$2}' /etc/os-release) main" | sudo tee /etc/apt/sources.list.d/adoptium.list && \
sudo apt update -y && \
sudo apt install -y temurin-21-jdk

ENV JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64

RUN rm -rf /var/lib/apt/lists/*
