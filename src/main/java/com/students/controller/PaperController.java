package com.students.controller;

import com.students.bean.Msg;
import com.students.bean.Paper;
import com.students.bean.SearchPaper;
import com.students.service.PaperService;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(value = "/Paper")
public class PaperController {
    @Autowired
    private PaperService paperService;


    @ResponseBody
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Msg review(String isPassed, Integer paperId, String reason){
        paperService.review(isPassed, paperId, reason);
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Msg getPaper(@PathVariable("id")Integer id){
        Paper paper = paperService.getPaper(id);
        if(paper != null){
            return Msg.success().add("paper", paper);
        }
        return Msg.fail().add("msg", "获取论文失败");
    }

    /*分页获取论文*/
    @ResponseBody
    @RequestMapping(value = "/{stuId}/{status}", method = RequestMethod.GET)
    public Msg getPaper(@PathVariable("stuId") String stuId,
                        @PathVariable("status") Integer status){
        PageBean<Paper> paperPageBean = paperService.getAllByPage(stuId, status);
        return Msg.success().add("pageBean", paperPageBean);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Msg addPaper(@RequestParam(value = "paper") String s,
                        @RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
        int result;
        String originalName;

        JSONObject jsonObject = JSONObject.fromObject(s);
        Paper paper = (Paper)JSONObject.toBean(jsonObject, Paper.class);
        paper.setDate(Data.stringToShortDate(jsonObject.get("date").toString()));

        if(!Data.isValid(paper.getId())){
            if(file == null){
                return Msg.fail().add("msg", "文件为空，请上传PDF文件");
            }
        }

        result = paperService.addOrUpdatePaper(paper, file);

        if(result == 0){
            return Msg.fail().add("msg", "提交/更新论文失败");
        }
        return Msg.success();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Msg deletePaper(@PathVariable("id")Integer id){
        if(!paperService.deletePaper(id)){
            return Msg.fail().add("msg","删除失败");
        }
        return Msg.success().add("msg", "删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "/same", method = RequestMethod.GET)
    public Msg getSamePaper(@RequestParam("name")String name){
        List<Paper> list = paperService.getSamePaper(name);
        if(list == null){
            return Msg.fail();
        }
        return Msg.success().add("list", list);
    }

    @ResponseBody
    @RequestMapping(value = "/_search", method = RequestMethod.POST)
    public Msg fuzzySearch(@RequestBody SearchPaper paper){
        PageBean<Paper> paperPageBean = paperService.fuzzySearch(paper);
        return Msg.success().add("pageBean", paperPageBean);
    }

    @ResponseBody
    @RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(@PathVariable("id")Integer i) throws IOException {
        Paper paper = paperService.getPaper(i);
        if(paper != null){
            String path = paper.getFile();
            String fileName;

            File file = new File(path);
            fileName = file.getName();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_PDF);

            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        }
        return null;
    }
}
