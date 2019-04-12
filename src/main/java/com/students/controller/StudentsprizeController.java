package com.students.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.DefaultValue;

import com.students.bean.SearchPrize;
import com.students.utils.Pagination.PageBean;
import jdk.nashorn.internal.ir.RuntimeNode;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.students.bean.Msg;
import com.students.bean.Studentsprize;
import com.students.service.StudentsprizeService;

@Controller
@CrossOrigin
public class StudentsprizeController {

    /*status  0 未审核 1审核通过  2审核未通过
     * add
     * get:   1.管理员通过学号得到状态0 的prize
     *        2.学生通过学号以及不同状态得到自己的奖项状态和信息
     *        3.统一为一个方法 参数：stuId  status
     *
     * delete: 参数：prizeId
     *
     *
     * update:参数 prizeId
     *
     * 审核通过和未通过方法check :参数 boolean isPassed,  prizeId
     * 证明信息的存储：file存储量信息的存储位置 前端通过
     */
    @Autowired
    private StudentsprizeService studentsprizeService;

//	
//	@ResponseBody
//	@RequestMapping(value="/Studentsprize",method=RequestMethod.POST)
//	public Msg addPrize(@RequestBody Studentsprize studentsPrize,MultipartFile file){
//		System.out.println(studentsPrize);
//
//		if(file!=null){
//		String originalName=file.getOriginalFilename();
//		String fileName=UUID.randomUUID()+ originalName.substring(originalName.lastIndexOf("."));
//		String savePath="D:\\file\\"+fileName;
//		File filePath=new File(savePath);
//		
//		
//		
//		
//		try {
//			file.transferTo(filePath);
//			
//			studentsPrize.setPrizeFile(savePath);
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}
//		studentsprizeService.addPrize(studentsPrize);
//		
//		return Msg.success();
//	}

    /**
     * @description 
     * @param studentsPrizeString
     * @param file
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/11 10:05
     **/
    @ResponseBody
    @RequestMapping(value = "/Studentsprize", method = RequestMethod.POST)
    public Msg addPrize(@RequestParam(value = "prize") String studentsPrizeString,
                        @RequestParam(value = "file") MultipartFile file) throws IOException {
        JSONObject jsonObject = JSONObject.fromObject(studentsPrizeString);
        Studentsprize studentsPrize = (Studentsprize) JSONObject.toBean(jsonObject, Studentsprize.class);
        if (studentsprizeService.addPrize(studentsPrize, file)) {
            return Msg.success();
        }else {
            return Msg.fail().add("msg", "添加新的奖项失败");
        }
    }


    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public void testFile(MultipartFile file, Integer prizeId) {
        System.out.println(prizeId);

        if (file != null) {


            String originalName = file.getOriginalFilename();
            String fileName = UUID.randomUUID() + originalName.substring(originalName.lastIndexOf("."));
            String savePath = "/data/wwwroot/default/rcglk/images/" + fileName;
            //String savePath="D://"+fileName;
            File filePath = new File(savePath);


            try {
                file.transferTo(filePath);
                studentsprizeService.setFile(savePath, prizeId);


            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }


    /**
     * @param stuId  若需要批量查看未审核的信息将stuId赋值为null
     * @param status
     * @return
     */


    @ResponseBody
    @RequestMapping(value = "/Studentsprize/{stuId}/{status}", method = RequestMethod.GET)
    public Msg getPrize(@PathVariable("stuId") String stuId, @PathVariable("status") String status) {
        return Msg.success().add("pageBean", studentsprizeService.getPrizeByPage(stuId, status));
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsprize/_search", method = RequestMethod.POST)
    public Msg searchPrize(@RequestBody SearchPrize searchPrize) {
        PageBean<Studentsprize> pageBean = studentsprizeService.searchPrizeByPage(searchPrize);
        if (pageBean == null) {
            return Msg.fail();
        } else {
            return Msg.success().add("pageBean", pageBean);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/Studentsprize/{prizeId}", method = RequestMethod.DELETE)
    public Msg deletePrize(@PathVariable int prizeId) {
        boolean bool = studentsprizeService.deleteprize(prizeId);
        if (bool) {
            return Msg.success();
        }
        return Msg.fail().add("msg","删除奖项失败");
    }


    @ResponseBody
    @RequestMapping(value = "/Studentsprize/{prizeId}", method = RequestMethod.GET)
    public Msg getOne(@PathVariable int prizeId) {
        Studentsprize studentsprize = studentsprizeService.getOne(prizeId);
        Msg msg = new Msg();
        return Msg.success().add("prize", studentsprize);
    }


    /**
     * @description
     * @param studentsPrizeString
     * @param file
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/11 16:36
     **/
    @ResponseBody
    @RequestMapping(value = "/Studentsprize/update", method = RequestMethod.POST)

    public Msg updatePrize(@RequestParam(value = "prize") String studentsPrizeString,
                           @RequestParam(value = "file", required = false) MultipartFile file) throws IOException{
        JSONObject jsonObject = JSONObject.fromObject(studentsPrizeString);
        Studentsprize studentsPrize = (Studentsprize) JSONObject.toBean(jsonObject, Studentsprize.class);
        boolean bool = studentsprizeService.updatePrize(studentsPrize, file);
        if (bool) {
            return Msg.success();
        }
        return Msg.fail().add("msg", "更新奖项信息失败");
    }

    /**
     * 更新文件证明
     *
     * @param prizeId
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "/Studentsprize/updateFile/{prizeId}", method = RequestMethod.POST)

    public Msg updateFile(@PathVariable int prizeId, @RequestParam MultipartFile file) throws IllegalStateException, IOException {
        if (file != null) {
            String originalName = file.getOriginalFilename();
            String fileName = UUID.randomUUID() + originalName.substring(originalName.lastIndexOf("."));
            String savePath = "D:\\file\\" + fileName;
            File filePath = new File(savePath);
            if (filePath.setReadable(true)) {
                return Msg.fail().add("msg", "文件权限设置失败");
            }


            Studentsprize studentsprize = studentsprizeService.getOne(prizeId);
            studentsprize.setStatus("0");
            String oldPath = studentsprize.getPrizeFile();
            File oldFile = new File(oldPath);
            //删除已有的文件证明
            oldFile.delete();
            studentsprize.setPrizeFile(savePath);

            file.transferTo(filePath);

            studentsprizeService.savaPrize(studentsprize);


            return Msg.success();


        }
        return Msg.fail();

    }


    /**
     * 证明图片上传到前台
     *
     * @param prizeFile
     * @return
     * @throws IOException
     */

    @Deprecated
    @RequestMapping("/Studentsprize/download")
    public ResponseEntity<byte[]> download(@RequestParam String prizeFile) throws IOException {
        File file = new File(prizeFile);

        String fileName = new String(prizeFile.getBytes("UTF-8"), "iso-8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    /**
     * @description 审核奖项
     * @param isPassed
     * @param prizeId
     * @param reason
     * @return com.students.bean.Msg
     * @author zxy
     * @create 2019/4/12 10:38
     **/
    @ResponseBody
    @RequestMapping(value = "/Studentsprize/check", method = RequestMethod.POST)
    public Msg check(String isPassed, Integer prizeId, String reason) {
        studentsprizeService.check(isPassed, prizeId, reason);
        return Msg.success();
    }
}
