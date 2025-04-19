package ${package.Controller};

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${package.Parent}.service.service.${table.serviceName};
import ${package.Parent}.model.request.${entity}Request;
import ${package.Parent}.model.vo.${entity}VO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ronghuiwl.base.page.BasePageVO;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/public/${table.entityPath}")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
@Tag(name = "${table.comment!}管理")
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
@Tag(name = "${table.comment!}")
public class ${table.controllerName} {
</#if>
    @Autowired
    private ${entity}Service ${table.entityPath}Service;


    @PostMapping("/add")
    @Operation(summary = "创建${table.comment!}")
    public Boolean create(@RequestBody ${entity}Request request) {
        return ${table.entityPath}Service.create(request);
    }

    @PostMapping("/delete")
    @Operation(summary = "删除${table.comment!}")
    public Boolean delete(@RequestBody ${entity}Request request) {
        return ${table.entityPath}Service.delete(request.getId());
    }

    @PostMapping("/update")
    @Operation(summary = "修改${table.comment!}")
    public Boolean update(@RequestBody ${entity}Request request) {
        return ${table.entityPath}Service.updateById(request);
    }

    @PostMapping("/get")
    @Operation(summary = "获取${table.comment!}详情")
    public ${entity}VO getById(@RequestBody ${entity}Request request) {
        return ${table.entityPath}Service.get${entity}ById(request);
    }

    @PostMapping("/list")
    @Operation(summary = "分页查询${table.comment!}")
    public BasePageVO<${entity}VO> page(@RequestBody UploadRecordsRequest request) {
        return ${table.entityPath}Service.page(request);
    }
}
</#if>
