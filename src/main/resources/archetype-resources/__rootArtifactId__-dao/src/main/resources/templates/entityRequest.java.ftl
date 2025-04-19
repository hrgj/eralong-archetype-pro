package ${package.Parent}.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import com.ronghuiwl.base.page.BaseRequest;

/**
* <p>
* ${table.comment!}请求参数
* </p>
*
* @author ${author}
* @since ${date}
*/
@Data
@Schema(name = "${entity}Request", description = "${table.comment!}请求参数")
public class ${entity}Request extends BaseRequest {


<#list table.fields as field>
    <#if field.comment!?length gt 0>
    @Schema(description = "${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

}