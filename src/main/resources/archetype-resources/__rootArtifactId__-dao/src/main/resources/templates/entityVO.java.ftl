package ${package.Parent}.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;

/**
* <p>
* ${table.comment!}VO
* </p>
*
* @author ${author}
* @since ${date}
*/
@Data
@Accessors(chain = true)
@Schema(name = "${entity}VO", description = "${table.comment!}VO")
public class ${entity}VO implements Serializable {


<#list table.fields as field>
    <#if field.comment!?length gt 0>
    @Schema(description = "${field.comment}")
    </#if>
    private ${field.propertyType} ${field.propertyName};
</#list>

}