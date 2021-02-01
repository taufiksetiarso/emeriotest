package emeriotest.emeriotest.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Siswa {
    @Id
    @Column(name = "nomor_induk", length = 40)
    private String nomorInduk;
    @Column
    private String nama;
    @Column

    private String kelas;

    public String getNomorInduk() {
        return nomorInduk;
    }

    public void setNomorInduk(String nomorInduk) {
        this.nomorInduk = nomorInduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
