# OpenAPI xFx Web Service


## Technologies
- Service definition language: OAS (OpenAPI Specification) 3.0
- Protocol: Raw HTTP
- Provider programming language: Java. We leverage the power of Spring Boot as an opinionated application framework to easily develop and expose a basic web service
- Consumer programming language: Python (Generated through Swagger tools)

## Development Process (Code-first)
### Define the API endpoints
Define RESTful API endpoints for browsing the shared folder, renaming files/folders, downloading files, uploading files, and deleting files.

### Develop the Java provider
 You can just clone this repository or initialize your own Spring Boot application.
To initialize a Spring Boot application, you need to create a Gradle project, customized with the necessary Spring Boot dependencies. Spring Boot Initializr provides a user-friendly UI to do so.
- Go to Spring Boot Initializr: https://start.spring.io
- Choose Gradle Project + Java Language + the latest stable version of Spring Boot
- Set project metadata
- Add Spring Web dependency (Just search for *rest*)
- Hit *GENERATE*

You will get your initialized Gradle project as a zip file. Unzip it and this will be your work/project directory.

### Generate the OpenAPI Service Description
We generate the OpenAPI service description from rs.xfx.FileController. To do so, we use Springdoc-OpenAPI generation tool:
- Add 'org.springdoc:springdoc-openapi-ui:1.5.5' dependency to build.gradle
- Access `http://localhost:8080/v3/api-docs`
- Copy the output. This is our xFx OpenAPI definition

### Develop the Python consumer
- Generate Python client stub from the generated xFx OpenAPI definition using [SwaggerHub.com](https://www.swaggerhub.com)
- Unzip the generated python code under `app/src/main/python`
- Get to the unzipped folder and run: `python setup.py install`
- Write the consumer: `app/src/main/python/consumer.py`
- Run it: `python app/src/main/python/consumer.py`


## API Documentation

- [GET /files](#get-file)
- [POST /files](#upload-file)
- [GET /files/{filename}](#download-file)
- [PUT /files/{filename}](#rename-file)
- [DELETE /files/{filename}](#delete-file)


<a name="get-file"></a>
### Get List of Files

    Get /files
*Client function: get_files*

*Return type array[String]*

<a name="upload-file"></a>
### Upload File
    POST /files
*Client function: upload_file*

**Params**:
- filename (optional)
- file (required)

*Return type Object* 

<a name="download-file"></a>
### Download File
    GET /files/{filename}
*Client function: get_file*

**Params**:
- filename (required)

<a name="rename-file"></a>
### Rename File
    PUT /files/{filename}
*Client function: rename_file*

**Params**:
- filename (required)
- newFileName (required)

<a name="delete-file"></a>
### Delete File
    DELETE /files/{filename}
*Client function: delete_file*

**Params**:
- filename (required)
