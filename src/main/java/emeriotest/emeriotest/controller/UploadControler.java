package emeriotest.emeriotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UploadControler {
    @GetMapping(value = {"/"})
    public String index(ModelMap model) {
        return "index";
    }

    @GetMapping(value = {"/upload/siswa"})
    public String siswa(ModelMap model) {
        return "uploadsiswa";
    }

    @GetMapping(value = {"/upload/nilai"})
    public String nilai(ModelMap model) {
        return "uploadnilai";
    }
}
