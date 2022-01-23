package com.lquan.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lquan.bean.req.ReqQuartzJobDto;
import com.lquan.domain.TbQuartzJob;
import com.lquan.exception.BizException;
import com.lquan.exception.SystemException;
import com.lquan.resp.ResultData;
import com.lquan.service.TbQuartzJobService;
import com.lquan.service.impl.QuartzSchedulerService;
import com.lquan.util.Constant;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/job")
public class QuartzJobController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private ISysJobService sysJobService;
	@Autowired
	private TbQuartzJobService tbQuartzJobService;

	@Autowired
	private QuartzSchedulerService quartzSchedulerService;

	/**
	 * 打开列表页
	 * @return
	 */
	@RequestMapping("/jobList")
	public String jobList() {
		//return "quartz/jobListPage";
		return "jobListPage";
	}

	/**
	 * 打开详情界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toDetail")
	public String toDetail(Integer id, Model model) {
	//	SysJob job = sysJobService.selectByPrimaryKey(id);
		TbQuartzJob job = this.tbQuartzJobService.queryById(id);
		model.addAttribute("job",job);
		//return "quartz/jobDetail";
		return "jobDetail";
	}

	/**
	 * 打开修改界面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(Integer id, Model model) {
		TbQuartzJob job = this.tbQuartzJobService.queryById(id);
		model.addAttribute("job",job);
		return "quartz/jobUpdate";
	}

	/**
	 * 打开新增界面
	 * @return
	 */
	@RequestMapping("/toJob")
	public String toJob (){
		return "quartz/jobAdd";
	}

	/**
	 * 查询任务列表（带分页）
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.GET)
	@ResponseBody
	public ResultData<TbQuartzJob> queryJobList(HttpServletRequest request, HttpServletResponse response) {
		String idStr = request.getParameter("id");
		String jobName = request.getParameter("jobName");
		String jobGroup = request.getParameter("jobGroup");
		String jobCron = request.getParameter("jobCron");
		String jobClassPath = request.getParameter("jobClassPath");
		String jobDescribe = request.getParameter("jobDescribe");

		ReqQuartzJobDto tbQuartzJob = new ReqQuartzJobDto();
		HashMap<String, String> map = new HashMap<String, String>();
		if (StringUtils.isNotBlank(idStr)) {
			//map.put("id", idStr);
			tbQuartzJob.setId(Integer.valueOf(idStr));
		}
		if (StringUtils.isNotBlank(jobName)) {
			//map.put("jobName", jobName);
			tbQuartzJob.setJobName(jobName);
		}
		if (StringUtils.isNotBlank(jobGroup)) {
			//map.put("jobGroup", jobGroup);
			tbQuartzJob.setJobGroup(jobGroup);
		}
		if (StringUtils.isNotBlank(jobCron)) {
			//map.put("jobCron", jobCron);
			tbQuartzJob.setJobCron(jobCron);
		}
		if (StringUtils.isNotBlank(jobClassPath)) {
			//map.put("jobClassPath", jobClassPath);
			tbQuartzJob.setJobClassPath(jobClassPath);
		}
		if (StringUtils.isNotBlank(jobDescribe)) {
			//map.put("jobDescribe", jobDescribe);
			tbQuartzJob.setJobDescribe(jobDescribe);
		}

		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		if(page>=1){
			page = (page-1)*limit;
		}
		try {

			PageHelper.startPage(page,limit);
			List<TbQuartzJob> jobList= this.tbQuartzJobService.queryQuartzJobList(tbQuartzJob);
			//生成分页信息对象
			PageInfo<TbQuartzJob> pageInfo = new PageInfo<>(jobList);

			return ResultData.bulidSuccessPageResult(pageInfo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加定时任务
	 *
	 * @throws Exception
	 */
	@PostMapping(value = "/addJob")
	@ResponseBody
	@Transactional
	public int addjob(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("添加任务开始... ...");
		int num =0;
		String jobName = request.getParameter("jobName");
		String jobClassPath= request.getParameter("jobClassPath");
		String jobGroup= request.getParameter("jobGroup");
		String jobCron= request.getParameter("jobCron");
		String jobDescribe= request.getParameter("jobDescribe");
		String jobDataMap= request.getParameter("jobDataMap");
		
		if (StringUtils.isBlank(jobName)) {
			throw new SystemException("任务名称不能为空");
		}
		if (StringUtils.isBlank(jobGroup)) {
			throw new SystemException("任务组别不能为空");
		}
		if (StringUtils.isBlank(jobCron)) {
			throw new SystemException("Cron表达式不能为空");
		}
		if (StringUtils.isBlank(jobClassPath)) {
			throw new SystemException("任务类路径不能为空");
		}
		
		// 参数不为空时校验格式
		if(StringUtils.isNotBlank(jobDataMap)){
			try {
				JSONObject.parseObject(jobDataMap);
			} catch (Exception e) {
				throw new SystemException("参数JSON格式错误");
			}
		}
		
		// 已存在校验
		/*SysJob queryBean = new SysJob();
		queryBean.setJobName(jobName);*/
		TbQuartzJob queryBean = new TbQuartzJob();
		queryBean.setJobName(jobName);
		//SysJob result = sysJobService.selectByBean(queryBean);
		//SysJob result = sysJobService.selectByBean(queryBean);
		TbQuartzJob result = this.tbQuartzJobService.queryQuartzJobList(queryBean).get(0);
		if (null != result) {
			throw new BizException("任务名为" + jobName + "的任务已存在！");
		}

		TbQuartzJob bean = new TbQuartzJob();
		bean.setJobName(jobName);
		bean.setJobClassPath(jobClassPath);
		bean.setJobGroup(jobGroup);
		bean.setJobCron(jobCron);
		bean.setJobDescribe(jobDescribe);
		bean.setJobDataMap(jobDataMap);
		bean.setJobStatus(Constant.JOB_STATE.YES);
		try {
			//num = sysJobService.insertSelective(bean);
			 this.tbQuartzJobService.insertSelective(bean);
		} catch (Exception e) {
			throw new BizException("新增定时任务失败");
		}

		this.quartzSchedulerService.addBeanJob(bean);
		return 1;
	}
	
	/**
	 * 变更定时任务执行状态
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/changeState")
	@ResponseBody
	public int changeState(@RequestParam(value = "id") String idStr)throws Exception {
        logger.info("变更定时任务状态开始... ...");
		if (StringUtils.isBlank(idStr)) {
			throw new BizException("任务ID不能为空");
		}
		int id = Integer.parseInt(idStr);

		// 校验
		TbQuartzJob queryBean = new TbQuartzJob();
		queryBean.setId(id);
		TbQuartzJob result =  this.tbQuartzJobService.selectByBean(queryBean);
		if (null == result) {
			throw new BizException("任务ID为" + id + "的任务不存在！");
		}

		TbQuartzJob updateBean = new TbQuartzJob();
		updateBean.setId(id);
		//如果是现在是启用，则停用
		if(Constant.JOB_STATE.YES == result.getJobStatus()){
			updateBean.setJobStatus(Constant.JOB_STATE.NO);
			Boolean b=this.quartzSchedulerService.isResume(result.getJobName(),result.getJobGroup());
		  if (b) {
			  quartzSchedulerService.jobdelete(result.getJobName(), result.getJobGroup());
		  }
		}
		
		//如果现在是停用，则启用
		if(Constant.JOB_STATE.NO == result.getJobStatus()){
			updateBean.setJobStatus(Constant.JOB_STATE.YES);
			//SchedulerUtil.jobresume(result.getJobName(), result.getJobGroup());
			 Boolean b=quartzSchedulerService.isResume(result.getJobName(), result.getJobGroup());
			 //存在则激活，不存在则添加
			  if (b) {
				  quartzSchedulerService.jobresume(result.getJobName(), result.getJobGroup());
			  }else {
				  quartzSchedulerService.addBeanJob(result);
			}
		}
		
		try {
			//sysJobService.updateByPrimaryKeySelective(updateBean);
			this.tbQuartzJobService.update(updateBean);
		} catch (Exception e) {
			throw new BizException("更新数据库的定时任务信息异常！");
		}
		// 1表示成功
		return 1;
		
	}

	/**
	 * 删除一个任务
	 *
	 * @throws Exception
	 */
	@PostMapping(value = "/deleteJob")
	@ResponseBody
	public int deletejob(@RequestParam(value = "id") String idStr) throws Exception {
        logger.info("删除定时任务状态开始... ...");
		int num =0;
		if (StringUtils.isBlank(idStr)) {
			throw new BizException("任务ID不能为空");
		}
		int id = Integer.parseInt(idStr);
		
		// 存在性校验
		TbQuartzJob queryBean = new TbQuartzJob();
		queryBean.setId(id);
		//SysJob result = sysJobService.selectByBean(queryBean);
		TbQuartzJob result = this.tbQuartzJobService.selectByBean(queryBean);
		if (null == result) {
			throw new BizException("任务ID为" + idStr + "的任务不存在！");
		}
		
		try {
			num = this.tbQuartzJobService.deleteById(id);//.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new BizException("从数据库删除定时任务时发生异常！");
		}

		quartzSchedulerService.jobdelete(result.getJobName(), result.getJobGroup());
		return num;
	}

	/**
	 * 修改定时表达式
	 */
	@RequestMapping("/reSchedulejob")
	@ResponseBody
	public int updateByBean(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("修改定时任务信息开始... ...");
		int num =0;
		String jobCron = request.getParameter("jobCron");
		String jobDescribe = request.getParameter("jobDescribe");
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		// 数据非空校验
		if (!StringUtils.isNotBlank(idStr)) {
			throw new BizException("任务ID不能为空");
		}
		//SysJob result = sysJobService.selectByPrimaryKey(id);
		TbQuartzJob result = this.tbQuartzJobService.queryById(id);//.selectByPrimaryKey(id);
		// 数据不存在
		if (null == result) {
			throw new BizException("根据任务ID[" + id + "]未查到相应的任务记录");
		}
		TbQuartzJob bean = new TbQuartzJob();
		bean.setId(id);
		bean.setJobCron(jobCron);
		bean.setJobDescribe(jobDescribe);
		try {
		//	num = sysJobService.updateByPrimaryKeySelective(bean);
			this.tbQuartzJobService.update(bean);

		} catch (Exception e) {
			throw new BizException("变更任务表达式异常：" + e.getMessage());
		}
		//只有任务状态为启用，才开始运行
		// 如果先启动再手工插入数据，此处会报空指针异常
		if( result.getJobStatus() ==Constant.JOB_STATE.YES ){
			quartzSchedulerService.modifyJobTime(result.getJobName(), result.getJobGroup(),jobCron);
		}
		
		// 返回成功
		return 1;
	}

	/**
	 * 展示任务调度管理页
	 * 
	 * @param request
	 * @param rep
	 * @return
	 */
	@RequestMapping(value = "/jobPage", method = RequestMethod.GET)
	public String getJobPage(HttpServletRequest request, HttpServletResponse rep) {
		return "job/job_info";
	}
}
