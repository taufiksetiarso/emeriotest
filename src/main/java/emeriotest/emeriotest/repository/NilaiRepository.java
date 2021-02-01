package emeriotest.emeriotest.repository;

import emeriotest.emeriotest.model.Nilai;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface NilaiRepository extends CrudRepository<Nilai, Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE Nilai n set n.nilai =:nilai where n.mata_pelajaran = :mapel and n.nomor_induk= :id",
            nativeQuery = true)
    void updateNilai(@Param("id") String nomorInduk, @Param("mapel") String userId, @Param("nilai") String nilai);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Nilai n where n.mata_pelajaran = :mapel and n.nomor_induk= :id",
            nativeQuery = true)
    void hapusMapel(@Param("id") String nomorInduk, @Param("mapel") String userId);


}
