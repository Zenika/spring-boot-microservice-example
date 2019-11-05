Vault details:
Download url: https://www.vaultproject.io/downloads.html
Extract and run: ./vault server -dev
On a different console do the below
    export VAULT_ADDR='http://localhost:8200'
    ./vault secrets enable -path=catalog-service
    ./vault write secret/catalog-service spring.datasource.username=root spring.datasource.password=admin
Read to verify the write operation
    ./valut read catalog-service/catalog-service