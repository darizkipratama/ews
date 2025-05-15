# ews

Modul Yang Dibangun Sebagai Agregator Sensor Pengawasan Daerah Aliran Sungai Di Indonesia

## Project Structure
`/src/*` structure follows default Java structure.
- `/src/main/docker` - Docker configurations for the application and services that the application depends on

## Development

To start your application in the dev profile, run:

```
./mvnw
```

## Building for production

### Packaging as jar

To build the final jar and optimize the ews application for production, run:

```
./mvnw -Pprod clean verify
```

To ensure everything worked, run:

```
java -jar target/*.jar
```

Refer to [Using JHipster in production][] for more details.

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```

## Testing

### Spring Boot tests

To launch your application's tests, run:

```
./mvnw verify
```
