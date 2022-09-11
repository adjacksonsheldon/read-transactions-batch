# read-transactions-batch

read-transactions-batch is a java application that reads a file and saves transactions in the database.

## Installation

Use the package manager maven to install read-transactions-batch.

```bash
mvn install
```

## Environment variables

```
SPRING_BATCH_DB_URL=
TRANSACTIONS_DB_URL=
SOURCE_FILES=
spring.cloud.azure.keyvault.secret.property-sources[0].credential.client-id=
spring.cloud.azure.keyvault.secret.property-sources[0].credential.client-secret=
spring.cloud.azure.keyvault.secret.property-sources[0].endpoint=
spring.cloud.azure.keyvault.secret.property-sources[0].profile.tenant-id=
```

## Additional Information
I used Azure Key Vault to store the database secrets.

My key vault contains database-password and database-user properties
