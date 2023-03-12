from swagger_client import FileControllerApi

client = FileControllerApi()


# get list of files

files = client.get_files()

print(files)

# upload file

response = client.upload_file(file="./requirements.txt", filename="directory/rq.txt")

print(response.decode())

# download file

file = client.get_file(filename="annarabic.png")

with open('annarabic.png', 'wb') as f:
    f.write(file)

# rename file

response = client.rename_file(filename="file.yml", new_filename="docker.yml")

# delete file

response = client.delete_file(filename="docker.yml")