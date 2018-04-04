package com.linkedin.drelephant.schedulers;

import com.linkedin.drelephant.configurations.scheduler.SchedulerConfigurationData;

import java.util.Properties;
import java.util.Random;

/**
 * Created by jiahuilliu on 4/4/18.
 */
public class LhotseScheduler implements Scheduler{


    public static final String Lhotse_JOB_URL = "lhotse.link.job.url";
    public static final String Lhotse_JOB_ID = "lhotse.link.job.id";
    public static final String Lhotse_WORKFLOW_URL = "lhotse.link.workflow.url";
    public static final String Lhotse_WORKFLO_ID = "lhotse.link.execution.id";


    public static final String Lhotse_JOB_NAME = "lhotse.job.name";

    private String schedulerName;
    private String jobDefId;
    private String jobExecId;
    private String flowDefId;
    private String flowExecId;

    private String jobDefUrl;
    private String jobExecUrl;
    private String flowDefUrl;
    private String flowExecUrl;

    private String jobName;
    private int workflowDepth;


    public LhotseScheduler(String appId, Properties properties, SchedulerConfigurationData schedulerConfData){
        schedulerName = schedulerConfData.getSchedulerName();
        /*if (properties != null){
            loadInfo(appId,properties);
        }else {*/
        jobExecId = "job_e_jiahuilliu"+new Random().nextLong();
        jobDefId = "job_jiahuilliu";
        flowExecId = "flow_e_jiahuilliu"+new Random().nextLong();
        flowDefId = "flow_jiauilliu";

            workflowDepth = 0; // TODO: Add sub-workflow support
            jobName = "name_jiahuilliu";

            jobExecUrl = jobExecId;
            jobDefUrl = jobDefId;
            flowExecUrl = flowExecId;
            flowDefUrl = flowDefId;
    }
    private void loadInfo(String appId, Properties properties) {
        jobDefId = properties.getProperty(Lhotse_JOB_URL);
        jobExecId = properties.getProperty(Lhotse_JOB_ID);
        flowDefId = properties.getProperty(Lhotse_WORKFLOW_URL);
        flowExecId = properties.getProperty(Lhotse_WORKFLO_ID);

        // For Azkaban, The url and ids are the same
        jobExecUrl = jobExecId;
        jobDefUrl = jobDefId;
        flowExecUrl = flowExecId;
        flowDefUrl = flowDefId;

        workflowDepth = 0; // TODO: Add sub-workflow support
        jobName = properties.getProperty(Lhotse_JOB_NAME);
    }

    @Override
    public String getSchedulerName() {
        return schedulerName;
    }

    @Override
    public boolean isEmpty() {
        return jobDefId == null || jobExecId == null || flowDefId == null || flowExecId == null;
    }

    @Override
    public String getJobDefId() {
        return jobDefId;
    }

    @Override
    public String getJobExecId() {
        return jobExecId;
    }

    @Override
    public String getFlowDefId() {
        return flowDefId;
    }

    @Override
    public String getFlowExecId() {
        return flowExecId;
    }

    @Override
    public String getJobDefUrl() {
        return jobDefUrl;
    }

    @Override
    public String getJobExecUrl() {
        return jobExecUrl;
    }

    @Override
    public String getFlowDefUrl() {
        return flowDefUrl;
    }

    @Override
    public String getFlowExecUrl() {
        return flowExecUrl;
    }

    @Override
    public int getWorkflowDepth() {
        return workflowDepth;
    }

    @Override
    public String getJobName() {
        return jobName;
    }
}
