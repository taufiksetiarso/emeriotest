package emeriotest.emeriotest.repository;


import emeriotest.emeriotest.model.Siswa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SiswaRepository extends CrudRepository<Siswa, String> {

    @Query(value = "select s.nomor_induk,s.nama,n.mata_pelajaran,n.nilai from siswa as s inner join nilai as n on s.nomor_induk = n.nomor_induk ",
            nativeQuery = true)
    List<Object[]> getNilaiSiswaAll();

}
