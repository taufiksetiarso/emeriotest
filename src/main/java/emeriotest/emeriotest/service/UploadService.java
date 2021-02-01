package emeriotest.emeriotest.service;

import emeriotest.emeriotest.model.Nilai;
import emeriotest.emeriotest.model.Siswa;
import emeriotest.emeriotest.repository.NilaiRepository;
import emeriotest.emeriotest.repository.SiswaRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    SiswaRepository siswaRepository;
    @Autowired
    NilaiRepository nilaiRepository;
    private final Path root = Paths.get("input");

    public boolean save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void csvToDB(InputStream is, String nameFile) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));


        CSVParser csvParser = new CSVParser(fileReader,
                CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());


        Iterable<CSVRecord> csvRecords = csvParser.getRecords();

        for (CSVRecord csvRecord : csvRecords) {
            if (nameFile.equalsIgnoreCase("siswa")) {
                Siswa siswa = new Siswa();
                siswa.setNomorInduk("" + Integer.valueOf(csvRecord.get("nomor_induk")));
                siswa.setKelas(csvRecord.get("kelas"));
                siswa.setNama(csvRecord.get("nama"));
                siswaRepository.save(siswa);
            }
            if (nameFile.equalsIgnoreCase("nilai")) {
                Nilai nilai = new Nilai();
                nilai.setNomorInduk("" + Integer.valueOf(csvRecord.get("nomor_induk")));
                nilai.setMataPelajaran(csvRecord.get("mata_pelajaran"));
                nilai.setNilai(csvRecord.get("nilai"));
                nilaiRepository.save(nilai);
            }

        }


    }
}
