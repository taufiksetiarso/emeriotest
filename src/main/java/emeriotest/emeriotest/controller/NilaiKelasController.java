package emeriotest.emeriotest.controller;

import emeriotest.emeriotest.model.Nilai;
import emeriotest.emeriotest.service.NilaiSiswaService;
import emeriotest.emeriotest.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


@RestController
public class NilaiKelasController {

    @Autowired
    NilaiSiswaService nilaiSiswaService;
    @Autowired
    UploadService uploadService;

    @PostMapping("/inquiry-siswa")
    private Object inquirySiswa(@RequestParam(name = "nomorInduk", required = false) String nomorInduk,
                                @RequestParam(name = "nama", required = false) String nama,
                                @RequestParam(name = "mataPelajaran", required = false) String mataPelajaran,
                                @RequestParam(name = "nilai", required = false) String nilai) {

        if (nomorInduk == null && nama == null && mataPelajaran == null && nilai == null)
            return nilaiSiswaService.getAll();
        else return nilaiSiswaService.byFilter(nomorInduk, nama, mataPelajaran, nilai);

    }

    @PostMapping("/update-nilai")
    private Object updateNilai(@RequestBody Nilai req) {
        return nilaiSiswaService.updateNilai(req);
    }

    @PostMapping("/upload/siswa")
    public Object uploadFileSiswa(@RequestParam("file") MultipartFile file) {
        String message = "Uploaded file siswa sukses: " + file.getOriginalFilename();
        Map res = new HashMap();
        res.put("status", message);
        try {
            uploadService.csvToDB(file.getInputStream(), "siswa");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!uploadService.save(file))
            res.put("status", "Uploaded file siswa gagal cobalah dengan nama lain: " + file.getOriginalFilename());


        return res;
    }

    @PostMapping("/upload/nilai")
    public Object uploadFileNilai(@RequestParam("file") MultipartFile file) {

        String message = "Uploaded file nilai sukses: " + file.getOriginalFilename();
        Map res = new HashMap();
        res.put("status", message);
        try {
            uploadService.csvToDB(file.getInputStream(), "nilai");

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!uploadService.save(file))
            res.put("status", "Uploaded file siswa gagal cobalah dengan nama lain " + file.getOriginalFilename());


        return res;
    }

    @PostMapping("/hapus-mapel")
    private Object hapusMapel(@RequestBody Nilai req) {

        return nilaiSiswaService.hapusMapel(req);
    }


}
