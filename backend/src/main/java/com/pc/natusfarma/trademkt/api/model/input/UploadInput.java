package com.pc.natusfarma.trademkt.api.model.input;


import org.springframework.web.multipart.MultipartFile;

public class UploadInput {

    private MultipartFile arquivo;

    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }
}
