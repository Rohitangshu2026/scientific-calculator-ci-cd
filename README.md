# Scientific Calculator CI/CD Pipeline

A fully automated **CI/CD pipeline for a Java-based Scientific Calculator application** using modern DevOps tools including **GitHub, Jenkins, Maven, Docker, DockerHub, and Ansible**.

This project demonstrates how code changes automatically trigger a pipeline that **builds, tests, packages, containerizes, and deploys the application**.

---

# Project Overview

Continuous Integration and Continuous Deployment (CI/CD) are practices that automate software development workflows. This project implements a CI/CD pipeline where every code push automatically triggers the build and deployment process.

The pipeline performs the following tasks:

1. Detects code changes via **GitHub Webhooks**
2. Jenkins automatically triggers the pipeline
3. Source code is retrieved from GitHub
4. The application is built using **Maven**
5. Unit tests are executed using **JUnit**
6. A Docker image is created
7. The image is pushed to **DockerHub**
8. Deployment is performed automatically using **Ansible**

This ensures that only **tested and verified code is deployed**.

---

# Tech Stack

| Tool | Purpose |
|-----|------|
| GitHub | Version control and repository hosting |
| Jenkins | CI/CD automation server |
| Maven | Java build and dependency management |
| Docker | Containerization of application |
| DockerHub | Container image registry |
| Ansible | Automated deployment |
| ngrok | Expose local Jenkins server for GitHub webhooks |

---

# CI/CD Pipeline Architecture

The pipeline architecture follows this workflow:
```
Developer
    |
Push Code
    |
GitHub Repository
    |
GitHub Webhook
    |
ngrok Tunnel
    |
Jenkins CI/CD Pipeline
    |
Build → Test → Package
    |
Docker Image Build
    |
Push to DockerHub
    |
Deploy using Ansible
    |
Application runs in Docker Container
```

Whenever code is pushed to the repository, Jenkins automatically executes the pipeline.

---

# Pipeline Stages

The pipeline is defined in a **Jenkinsfile using Declarative Pipeline syntax**.

### 1. Checkout SCM
Jenkins retrieves the latest source code from the GitHub repository.

### 2. Build Application
The project is compiled using Maven.
```bash
mvn clean package -DskipTests
```

This generates the compiled JAR file.

### 3. Run Unit Tests
JUnit tests are executed to verify the correctness of the calculator operations.
```bash
mvn test
```

If any test fails, the pipeline stops.

### 4. Verify Build Artifact
This stage confirms that the compiled JAR file exists.
```bash
ls -lh target/
```

### 5. Build Docker Image
A Docker image containing the application is created.
```bash
docker build -t scientific-calculator .
```


### 6. Push Docker Image to DockerHub
The Docker image is pushed to DockerHub using Jenkins credentials.
```bash
docker push <dockerhub-username>/scientific-calculator:latest
```

### 7. Deploy Using Ansible
An Ansible playbook deploys the application by:

- Pulling the latest Docker image
- Stopping the existing container
- Removing the old container
- Starting a new container
```bash
ansible-playbook -i inventory deploy.yml 
```

---

# Docker Containerization

The application is containerized using Docker.

### Dockerfile
```declarative
FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
```

The container runs the Java application when started.

---

# GitHub Webhook Integration

The pipeline is automatically triggered using **GitHub Webhooks**.

Since Jenkins runs locally, **ngrok is used to expose the Jenkins server to the internet** so GitHub can deliver webhook events.

Webhook flow:
```declarative
GitHub Push
    ↓
GitHub Webhook
    ↓
ngrok Tunnel
    ↓
Local Jenkins Server
    ↓
Pipeline Execution
```


---

# Deployment Workflow

Deployment is automated using Ansible.

The playbook performs the following steps:

1. Pull latest Docker image
2. Stop running container
3. Remove existing container
4. Run new container

This ensures **zero manual deployment steps**.

---

# Failure Handling

The CI/CD pipeline stops execution if tests fail.

For example, if a logical error is introduced in the code, the unit tests will fail and the pipeline will not proceed to the deployment stage.

Jenkins also sends **email notifications** when a build fails.

---

# Running the Application

Once deployed, the application runs inside a Docker container.

## Attach to the Running Container

To attach your terminal to the running container:

```bash
docker attach scientific-calculator
```

This connects your terminal directly to the container's main process.



## Execute Commands Inside the Running Container

If you want to open a shell inside the running container without attaching to the main process:

```bash
docker exec -it scientific-calculator /bin/bash
```
---
# Author

**Rohitangshu Bose**

Enrollment No: MT2025106