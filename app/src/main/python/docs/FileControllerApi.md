# swagger_client.FileControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**delete_file**](FileControllerApi.md#delete_file) | **DELETE** /files/{filename} | 
[**get_file**](FileControllerApi.md#get_file) | **GET** /files/{filename} | 
[**get_files**](FileControllerApi.md#get_files) | **GET** /files | 
[**rename_file**](FileControllerApi.md#rename_file) | **PUT** /files/{filename} | 
[**upload_file**](FileControllerApi.md#upload_file) | **POST** /files | 

# **delete_file**
> delete_file(filename)



### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = swagger_client.FileControllerApi()
filename = 'filename_example' # str | 

try:
    api_instance.delete_file(filename)
except ApiException as e:
    print("Exception when calling FileControllerApi->delete_file: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filename** | **str**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_file**
> str get_file(filename)



### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = swagger_client.FileControllerApi()
filename = 'filename_example' # str | 

try:
    api_response = api_instance.get_file(filename)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling FileControllerApi->get_file: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filename** | **str**|  | 

### Return type

**str**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **get_files**
> list[str] get_files()



### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = swagger_client.FileControllerApi()

try:
    api_response = api_instance.get_files()
    pprint(api_response)
except ApiException as e:
    print("Exception when calling FileControllerApi->get_files: %s\n" % e)
```

### Parameters
This endpoint does not need any parameter.

### Return type

**list[str]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **rename_file**
> rename_file(filename, new_filename)



### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = swagger_client.FileControllerApi()
filename = 'filename_example' # str | 
new_filename = 'new_filename_example' # str | 

try:
    api_instance.rename_file(filename, new_filename)
except ApiException as e:
    print("Exception when calling FileControllerApi->rename_file: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filename** | **str**|  | 
 **new_filename** | **str**|  | 

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **upload_file**
> object upload_file(file=file, filename=filename)



### Example
```python
from __future__ import print_function
import time
import swagger_client
from swagger_client.rest import ApiException
from pprint import pprint

# create an instance of the API class
api_instance = swagger_client.FileControllerApi()
file = 'file_example' # str |  (optional)
filename = 'filename_example' # str |  (optional)

try:
    api_response = api_instance.upload_file(file=file, filename=filename)
    pprint(api_response)
except ApiException as e:
    print("Exception when calling FileControllerApi->upload_file: %s\n" % e)
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **file** | **str**|  | [optional] 
 **filename** | **str**|  | [optional] 

### Return type

**object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

