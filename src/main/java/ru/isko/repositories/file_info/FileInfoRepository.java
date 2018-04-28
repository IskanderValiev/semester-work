package ru.isko.repositories.file_info;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isko.models.FileInfo;
import ru.isko.models.User;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {

    FileInfo findOneByStorageFileName(String storageFileName);
    FileInfo findOneByUser(User user);
}
