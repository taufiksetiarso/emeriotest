<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>File Uploading Form</title>

</head>


<body>
<h3>File Upload:</h3>
Select a file to upload: <br/>
<input type="button" class="button" value="Upload File Siswa" onclick="return validateFormOnSubmit('siswa')">
<input type="button" class="button" value="Upload File nilai" onclick="return validateFormOnSubmit('nilai')">
</body>
<script>
    function validateFormOnSubmit(theForm) {
        console.log(theForm)
        location.href = "${contextPath}/upload/" + theForm

        return false;
    }
</script>
</html>
