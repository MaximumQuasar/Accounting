package tutorial;

import com.atlassian.bamboo.specs.api.BambooSpec;
import com.atlassian.bamboo.specs.api.builders.plan.Job;
import com.atlassian.bamboo.specs.api.builders.plan.Plan;
import com.atlassian.bamboo.specs.api.builders.plan.PlanIdentifier;
import com.atlassian.bamboo.specs.api.builders.plan.Stage;
import com.atlassian.bamboo.specs.api.builders.project.Project;
import com.atlassian.bamboo.specs.builders.task.ScriptTask;
import com.atlassian.bamboo.specs.util.BambooServer;
import com.atlassian.bamboo.specs.api.builders.permission.Permissions;
import com.atlassian.bamboo.specs.api.builders.permission.PermissionType;
import com.atlassian.bamboo.specs.api.builders.permission.PlanPermissions;

/**
 * Plan configuration for Bamboo.
 * Learn more on: <a href="https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs">https://confluence.atlassian.com/display/BAMBOO/Bamboo+Specs</a>
 */
@BambooSpec
public class PlanSpec {


    Plan createPlan() {
       final Plan plan = new Plan(new Project()
                .oid(new BambooOid("o8et7z0jo26a"))
                .key(new BambooKey("PRJ"))
                .name("Project Name"),
            "Plan Name",
            new BambooKey("PLANKEY"))
            .oid(new BambooOid("o8540dnbu9s4"))
            .description("Plan created from (enter repository url of your plan)")
            .pluginConfigurations(new ConcurrentBuilds())
            .stages(new Stage("Stage 1")
                    .jobs(new Job("Build and Run",
                            new BambooKey("RUN"))
                            .tasks(new ScriptTask()
                                    .inlineBody("echo here we go again"))))
            .planBranchManagement(new PlanBranchManagement()
                    .delete(new BranchCleanup()))
            .forceStopHungBuilds();
        return plan;
    }


}
