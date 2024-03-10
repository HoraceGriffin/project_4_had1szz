package cn.had1szz.cyzy.controller;

import cn.had1szz.cyzy.response.Result;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.text.StrBuilder;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Horace Leoi
 * @since : 2024/3/8
 */
@RestController
@RequestMapping("/upload")
public class FileController {

    @Value("${uploadPath}")
    public String uploadPath;

    @GetMapping("/list")
    public Result<?> test() throws IOException {
        File file = new File(uploadPath);
        List<String> fileList = null;
        if (file.exists()) {
            fileList = Arrays.asList(file.list());
        }
        return Result.ok(fileList);
    }

    @PostMapping
    public Result<?> uploadFile(@RequestParam("file") MultipartFile file) {
        String name = file.getOriginalFilename();
        try {
            UUID uuid = UUID.fastUUID();
            StrBuilder fileStoreName = new StrBuilder(uuid.toString(), "-", name);
            File uploadPathFile = new File(uploadPath);
            if (!uploadPathFile.exists()) {
                uploadPathFile.mkdir();
            }
            file.transferTo(new File(uploadPath + fileStoreName));
        }
        catch (IOException e) {
            return Result.fail(400, "文件上传失败");
        }

        return Result.ok(null);
    }


}
