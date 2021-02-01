<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>File Uploading Form Nilai</title>

</head>


<body>
<h3>File Upload Nilai:</h3>
Select a file to upload: <br/>

<form action="${contextPath}/upload/nilai" method="post"
      enctype="multipart/form-data">
    <input type="file" name="file" size="50"/>
    <br/>
    <input type="submit" class="button" value="Upload File"/>
</form>
</body>
</html>
