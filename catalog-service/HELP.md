03 - Referring Vault to get DB credentials
* Download Vault from https://www.vaultproject.io/downloads.html
* Run Vault in dev mode `vault server -dev`
* On a separate console run `export VAULT_ADDR='http://localhost:8200'
* Tell Vault dev to mount version 1 of the secret engine instead of version 2
by running `vault secrets disable secret` and
`vault secrets enable -path=secret -version=1 kv`
* Log in to the vault browser at http://localhost:8200 using the token available in the console used to run vault
* Inside the secret engine, add the below json with path `catalog-service`
 ```
 {
    "spring.datasource.username": "root",
    "spring.datasource.password": "admin"
 }
 ```
Now the DB credentials are ready to be access from the Vault

06 - Publish application stats to Prometheus
* Add prometheus dependency
* Now when the application is started the Prometheus endpoint should be available (/actuator/prometheus)
* Download prometheus docker image <br>`docker pull prom/prometheus`
* Create a config file for Prometheus
* Run the image pointing to config file <br>
`docker run -p 9090:9090 -v <path to prom.yml>:/etc/prometheus/prometheus.yml prom/prometheus`
* Go to localhost:9090 to view the Prometheus dashboard
* Introducing Graphana <br>`docker run -d --name=grafana -p 3000:3000 grafana/grafana`