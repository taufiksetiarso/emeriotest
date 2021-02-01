package emeriotest.emeriotest.service;

import emeriotest.emeriotest.model.Nilai;
import emeriotest.emeriotest.model.NilaiSiswa;
import emeriotest.emeriotest.repository.NilaiRepository;
import emeriotest.emeriotest.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.persistence.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.*;

import static java.util.stream.Collectors.joining;

@Service
public class NilaiSiswaService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    SiswaRepository studentService;

    @Autowired
    NilaiRepository nilaiRepo;

    public Object getAll() {


        List<Object[]> queryResult1 = studentService.getNilaiSiswaAll();
        List<NilaiSiswa> queryResult = new LinkedList<>();

        for (Object[] result : queryResult1) {
            NilaiSiswa mi = new NilaiSiswa();
            mi.setNomorInduk((String) result[0]);
            mi.setNama((String) result[1]);
            mi.setMataPelajaran((String) result[2]);
            mi.setNilai((String) result[3]);
            queryResult.add(mi);
        }

        return queryResult;
    }

    public Object byFilter(String nomorInduk, String nama, String mataPelajaran, String nilai) {
        HashMap<String, String> whereClause = new HashMap();
        if (nomorInduk != null) whereClause.put("s.nomor_induk", nomorInduk);
        if (nama != null) whereClause.put("s.nama", nama);
        if (mataPelajaran != null) whereClause.put("n.mata_pelajaran", mataPelajaran);
        if (nilai != null) whereClause.put("n.nilai", nilai);

        String where = whereClause.entrySet()
                .stream()
                .map(e -> " " + e.getKey() + "='" + e.getValue() + "'")
                .collect(joining(" AND"));

        String query = "select s.nomor_induk,s.nama,n.mata_pelajaran,n.nilai from siswa as s inner join nilai as n on s.nomor_induk = n.nomor_induk where";
        System.out.println(query + where);
        Query jpaQuery = em.createNativeQuery(query + where);
        List<Object[]> queryResult1 = jpaQuery.getResultList();
        List<NilaiSiswa> queryResult = new LinkedList<>();

        for (Object[] result : queryResult1) {
            NilaiSiswa mi = new NilaiSiswa();
            mi.setNomorInduk((String) result[0]);
            mi.setNama((String) result[1]);
            mi.setMataPelajaran((String) result[2]);
            mi.setNilai((String) result[3]);
            queryResult.add(mi);
        }

        return queryResult;

    }

    public Map updateNilai(Nilai req) {
        Map res = new HashMap();
        nilaiRepo.updateNilai(req.getNomorInduk(), req.getMataPelajaran(), req.getNilai());
        res.put("status", "data berhasil di update");
        return res;
    }

    public Map hapusMapel(Nilai req) {
        Map res = new HashMap();
        nilaiRepo.hapusMapel(req.getNomorInduk(), req.getMataPelajaran());
        res.put("status", "data berhasil di hapus");
        return res;
    }

}
