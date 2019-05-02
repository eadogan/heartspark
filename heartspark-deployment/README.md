HeartSpark Deployment
=====

 Requirements
 - Kubernetes Cluster
 
 kubectl cluster can be downloaded from Digital Ocean Dashboard (certs expire weekly)

Install
- https://docs.cert-manager.io/en/latest/getting-started/install.html
- Apply Issuers (deployments/certs/kubernetes)
- Apply Secret for Docker Hub Registry
`kubectl create secret docker-registry docker-reg-cred --docker-server=docker.io --docker-username=<<user>> --docker-password=<<password>> --docker-email=<<email>>`
