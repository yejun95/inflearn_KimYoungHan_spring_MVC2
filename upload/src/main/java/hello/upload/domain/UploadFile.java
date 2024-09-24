package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName; // 사용자가 업로드하는 파일명
    private String storeFileName; // 서버에 저장하는 파일명, UUID 같이 고유 값을 넣어서 저장한다. -> 파일이 덮어씌우지 않기 위해

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
