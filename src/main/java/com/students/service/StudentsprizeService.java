package com.students.service;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.students.bean.SearchPrize;
import com.students.mapper.StudentsprizeMapper;
import com.students.utils.Data;
import com.students.utils.Pagination.PageBean;
import com.students.utils.Pagination.PaginationContext;
import com.students.utils.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.students.bean.Studentsprize;
import com.students.bean.StudentsprizeExample;
import com.students.bean.StudentsprizeExample.Criteria;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentsprizeService {

    @Autowired
    private StudentsprizeMapper studentsprizeMapper;

    /**
     * tonggu通过学号和审核状态得到prize信息
     *
     * @param stuId
     * @param status
     * @return
     */

    public List<Studentsprize> getPrize(String stuId, String status) {
        // TODO Auto-generated method stub
        StudentsprizeExample example = new StudentsprizeExample();
        Criteria cri = example.createCriteria();
        cri.andStatusEqualTo(status);
        if (!stuId.equals("0")) {
            System.out.println("1");
            cri.andStuIdEqualTo(stuId);
        }

        return studentsprizeMapper.selectByExample(example);
    }

    /*0 -1 查询所有学生所有状态*/
    public PageBean<Studentsprize> getPrizeByPage(String stuId, String status) {
        StudentsprizeExample example = new StudentsprizeExample();
        Criteria cri = example.createCriteria();
        if (!status.equals("-1")) {
            cri.andStatusEqualTo(status);
        }
        if (!stuId.equals("0")) {
            cri.andStuIdEqualTo(stuId);
        }
        return startSelect(example);
    }

    public List<Studentsprize> getAll(String status) {
        StudentsprizeExample example = new StudentsprizeExample();
        Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return studentsprizeMapper.selectByExample(example);
    }

    public PageBean<Studentsprize> searchPrizeByPage(SearchPrize searchPrize) {
        StudentsprizeExample example = new StudentsprizeExample();
        Criteria criteria = example.createCriteria();

        if (Data.isValid(searchPrize.getPrizeName())) {
            criteria.andPrizeNameLike("%" + searchPrize.getPrizeName() + "%");
        }
        if (Data.isValid(searchPrize.getStuId())) {
            criteria.andStuIdLike("%" + searchPrize.getStuId() + "%");
        }
        if (Data.isValid(searchPrize.getStuName())) {
            criteria.andStuNameLike("%" + searchPrize.getStuName() + "%");
        }
        if (Data.isValid(searchPrize.getPrizeClass())) {
            criteria.andPrizeClassLike("%" + searchPrize.getPrizeClass() + "%");
        }
        if (Data.isValid(searchPrize.getPrizeLevel())) {
            criteria.andPrizeLevelEqualTo(searchPrize.getPrizeLevel());
        }
        if (Data.isValid(searchPrize.getPrizeLevel2())) {
            criteria.andPrizeLevel2EqualTo(searchPrize.getPrizeLevel2());
        }

        /*获奖时间筛选*/
        if (Data.isValid(searchPrize.getPrizeDateBegin()) && Data.isValid(searchPrize.getPrizeDateEnd())) {
            criteria.andPrizeDateBetween(searchPrize.getPrizeDateBegin(), searchPrize.getPrizeDateEnd());
        } else if (Data.isValid(searchPrize.getPrizeDateBegin())) {
            criteria.andPrizeDateGreaterThanOrEqualTo(searchPrize.getPrizeDateBegin());
        } else if (Data.isValid(searchPrize.getPrizeDateEnd())) {
            criteria.andPrizeDateLessThanOrEqualTo(searchPrize.getPrizeDateEnd());
        }

        /*提交时间筛选*/
        if (Data.isValid(searchPrize.getSubmitDateBegin()) && Data.isValid(searchPrize.getSubmitDateEnd())) {
            criteria.andSubmitDateBetween(searchPrize.getSubmitDateBegin(), searchPrize.getSubmitDateEnd());
        } else if (Data.isValid(searchPrize.getSubmitDateBegin())) {
            criteria.andSubmitDateGreaterThanOrEqualTo(searchPrize.getSubmitDateBegin());
        } else if (Data.isValid(searchPrize.getSubmitDateEnd())) {
            criteria.andSubmitDateLessThanOrEqualTo(searchPrize.getSubmitDateEnd());
        }

        /*审核时间筛选*/
        if (Data.isValid(searchPrize.getReviewDateBegin()) && Data.isValid(searchPrize.getReviewDateEnd())) {
            criteria.andReviewDateBetween(searchPrize.getReviewDateBegin(), searchPrize.getReviewDateEnd());
        } else if (Data.isValid(searchPrize.getReviewDateBegin())) {
            criteria.andReviewDateGreaterThanOrEqualTo(searchPrize.getReviewDateBegin());
        } else if (Data.isValid(searchPrize.getReviewDateEnd())) {
            criteria.andReviewDateLessThanOrEqualTo(searchPrize.getReviewDateEnd());
        }

        return startSelect(example);
    }

    private PageBean<Studentsprize> startSelect(StudentsprizeExample example) {
        Page<Studentsprize> page = PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        PageBean<Studentsprize> studentsprizePageBean = new PageBean<Studentsprize>(studentsprizeMapper.selectByExample(example));
        studentsprizePageBean.setTotal(page.getTotal());
        studentsprizePageBean.setCurrPage(page.getPageNum());
        studentsprizePageBean.setPageSize(page.getPageSize());
        studentsprizePageBean.setPages(page.getPages());
        return studentsprizePageBean;
    }

    public boolean deleteprize(int prizeId) {
        // TODO Auto-generated method stub

        Studentsprize studentsprize = studentsprizeMapper.selectByPrimaryKey(prizeId);
        String filePath = Path.prize + studentsprize.getPrizeFile();
        File file = new File(filePath);

        if (!file.delete()) {
            return false;
        }

        int i = studentsprizeMapper.deleteByPrimaryKey(prizeId);
        if (i == 0) {
            return false;
        }
        return true;
    }

    public boolean savaPrize(Studentsprize studentsprize) {
        // TODO Auto-generated method stub

        studentsprize.setStatus("0");

        int i = studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
        System.out.println(studentsprize);
        System.out.println(i);
        if (i == 0) {


            return false;
        }
        return true;

    }

    /**
     * @Description:
     * @Param: studentsPrize
     * @Param: file
     * @Return: boolean
     * @author: zxy
     * @create: 2019/4/9 22:32
     **/
    public boolean addPrize(Studentsprize studentsPrize, MultipartFile file) throws IOException {
        // TODO Auto-generated method stub
        File savedFile = null;

        if (file != null) {
            if ((savedFile = saveFile(file)) != null) {
                Calendar ca = Calendar.getInstance();
                Date date = ca.getTime();
                studentsPrize.setStatus(Data.unReviewed.toString());
                studentsPrize.setPrizeFile(savedFile.getName());
                studentsPrize.setSubmitDate(date);
                if (studentsprizeMapper.insertSelective(studentsPrize) == 1) {
                    return true;
                }
                savedFile.delete();
            }
        }
        return false;
    }

    /**
     * @Description:
     * @Param: studentsprize
     * @Param: newFile
     * @Return: boolean
     * @author: zxy
     * @create: 2019/4/9 22:31
     **/
    public boolean updatePrize(Studentsprize studentsprize, MultipartFile newFile) throws IOException {
        Calendar ca = Calendar.getInstance();
        File savedFile = null;
        File oldFile = null;
        Studentsprize oldPrize = null;

        studentsprize.setStatus(Data.unReviewed.toString());
        studentsprize.setSubmitDate(ca.getTime());

        /*如果文件不为空，则插入新文件*/
        if (newFile != null) {
            /*存储新的证明文件*/
            if ((savedFile = saveFile(newFile)) != null) {
                /*传递的prizeId有效*/
                if (Data.isValid(studentsprize.getPrizeId())) {
                    oldPrize = studentsprizeMapper.selectByPrimaryKey(studentsprize.getPrizeId());
                    /*存在该id的记录*/
                    if (oldPrize != null) {
                        oldFile = new File(Path.prize + oldPrize.getPrizeFile());
                        studentsprize.setPrizeFile(savedFile.getName());
                        if (studentsprizeMapper.updateByPrimaryKeySelective(studentsprize) == 1) {
                            /*记录插入成功，删除旧的证明文件*/
                            oldFile.delete();
                            return true;
                        } else {
                            /*记录插入失败，删除新的证明文件*/
                            savedFile.delete();
                            return false;
                        }
                    }
                }
            }
            return false;
        }

        if (studentsprizeMapper.updateByPrimaryKeySelective(studentsprize) == 1) {
            return true;
        }
        return false;
    }

    private File saveFile(MultipartFile file) throws IOException {
        String orinalName = file.getOriginalFilename();
        String after = orinalName.substring(orinalName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().replace("-", "") + after;
        String savePath = Path.prize + fileName;
        File savedFile = new File(savePath);

        /*设置可读权限*/
        Runtime.getRuntime().exec("chmod 777 -R " + savePath);
        /*if (!savedFile.setReadable(true)) {
            return null;
        }*/
        file.transferTo(savedFile);
        return savedFile;
    }

    @Deprecated
    public void setFile(String fileph, int prizeId) {
        Studentsprize prize = studentsprizeMapper.selectByPrimaryKey(prizeId);
        prize.setPrizeFile(fileph);
        studentsprizeMapper.updateByPrimaryKey(prize);

    }

    public void check(String isPassed, Integer prizeId, String reason) {
        // TODO Auto-generated method stub
        Calendar ca = Calendar.getInstance();
        Date date = ca.getTime();

        Studentsprize studentsprize = new Studentsprize();
        studentsprize.setPrizeId(prizeId);
        studentsprize.setReviewDate(date);
        studentsprize.setReason(reason);

        if (isPassed.equals("pass")) {

            studentsprize.setStatus("1");

            studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
        } else {
            studentsprize.setStatus("2");
            studentsprizeMapper.updateByPrimaryKeySelective(studentsprize);
        }

    }

    public Studentsprize getOne(int prizeId) {
        // TODO Auto-generated method stub
        return studentsprizeMapper.selectByPrimaryKey(prizeId);
    }

    public PageInfo<Studentsprize> getByDate(int pageNum, int pageSize, Date submitDate1, Date submitDate2) {
        // TODO Auto-generated method stub
        return null;
    }

    public PageInfo<Studentsprize> getBySumbit(int pageNum, int pageSize, Date submitDate1, Date submitDate2) {
        // TODO Auto-generated method stub
        return null;
    }

}
