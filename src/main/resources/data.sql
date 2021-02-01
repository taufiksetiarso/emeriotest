DROP TABLE IF EXISTS siswa,nilai;

CREATE TABLE siswa (
  nomor_induk  VARCHAR(250)  PRIMARY KEY,
  nama VARCHAR(30) NOT NULL,
  kelas VARCHAR(30) NOT NULL
);

CREATE TABLE nilai (
  nomor_induk  VARCHAR(250)  ,
  mata_pelajaran VARCHAR(30) NOT NULL,
  nilai VARCHAR(30) NOT NULL
);
