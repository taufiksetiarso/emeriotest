# emeriotest



ada beberapa rest api yang digunakan:
1. (GET) http://localhost:8080/inquiry-siswa
   filter yang bisa digunakan : nomorInduk,mataPelajaran,nama,nilai 
   bisa digunakan lebih dari 1 filter contoh : http://localhost:8080/inquiry-siswa?nomorInduk=2&nama=Dangote
   *bila tidak menggunakan filter akan mencetak semua data
   
2. (POST) http://localhost:8080/update-nilai
   Content-Type: application/json
   dengan body request :
   {
      "nomorInduk":"3",
      "mataPelajaran":"sejarah",
      "nilai":"100"
   }

3. (POST) http://localhost:8080/hapus-mapel
   Content-Type: application/json
   dengan body request :
   {
      "nomorInduk":"3",
      "mataPelajaran":"sejarah"
   }

4. (POST) http://localhost:8080/upload/siswa   (untuk mempermudah upload silahkan buka link di browser)
    Content-Type: multipart/form-data; 
    upload file dengan format csv sebagai berikut
    https://github.com/taufiksetiarso/emeriotest/blob/main/input/siswa.csv
    
5. (POST) http://localhost:8080/upload/nilai (untuk mempermudah upload silahkan buka link di browser)
    Content-Type: multipart/form-data; 
    upload file dengan format csv sebagai berikut
    https://github.com/taufiksetiarso/emeriotest/blob/main/input/nilai.csv
 
 
 untuk postaman collection rest api diatas bisa menggunakan yang ini 
    
    
    
    
    
