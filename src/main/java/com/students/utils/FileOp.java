package com.students.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author zxy
 * @program rcglk
 * @description 对文件的操作
 * @email zxy@nmzl.cc
 * @date 2019-04-14-15:20
 **/
public class FileOp {

    /**
     * @description 保存文件，文件名更改为32位uuid，后缀不变
     * @param file 需要保存的文件
     * @param path 保存路径
     * @return java.io.File
     * @author zxy
     * @create 2019/4/14 16:05
     **/
    public static File save(MultipartFile file, String path) throws IOException {
        String originalName = file.getOriginalFilename();
        String after = originalName.substring(originalName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-","") + after;
        String savePath = path + fileName;
        File saveFile = new File(savePath);

        /*设置可读权限*/
        //Runtime.getRuntime().exec("chmod 777 -R " + savePath);
        /*if(!saveFile.setReadable(true)){
            return null;
        }*/
        file.transferTo(saveFile);
        return saveFile;
    }

    /**
     * @description 删除文件
     * @param fullPath 文件的完整路径，包括文件名
     * @return boolean
     * @author zxy
     * @create 2019/4/14 16:09
     **/
    public static boolean delete(String fullPath) {
        File file = new File(fullPath);
        return file.delete();
    }
}
